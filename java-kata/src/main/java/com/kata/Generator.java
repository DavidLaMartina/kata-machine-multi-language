package com.kata;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kata.AlgorithmDefinitions.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class Generator {
    private static final String SRC_PATH = "src/main/java/com/kata";
    private static final String TEST_PATH = "src/test/java/com/kata";
    
    public static void main(String[] args) throws IOException {
        generate();
    }
    
    public static void generate() throws IOException {
        // Read configuration
        ObjectMapper mapper = new ObjectMapper();
        JsonNode config = mapper.readTree(new File("kata.config.json"));
        List<String> dsaList = new ArrayList<>();
        config.get("dsa").forEach(node -> dsaList.add(node.asText()));
        
        // Calculate next day number
        int day = getNextDayNumber();
        String dayName = "day" + day;
        Path dayPath = Paths.get(SRC_PATH, dayName);
        
        // Clean and create day directory
        if (Files.exists(dayPath)) {
            deleteDirectory(dayPath);
        }
        Files.createDirectories(dayPath);
        
        // Get algorithm definitions
        Map<String, AlgorithmDef> definitions = AlgorithmDefinitions.getDefinitions();
        
        // Generate files for each algorithm
        for (String dsName : dsaList) {
            AlgorithmDef def = definitions.get(dsName);
            if (def == null) {
                throw new RuntimeException("Algorithm " + dsName + " not found in definitions");
            }
            
            if ("class".equals(def.type)) {
                generateClass(dayPath, dsName, def);
            } else {
                generateFunction(dayPath, dsName, def);
            }
        }
        
        // Update configuration files
        updatePomXml(dayName);
        updateStats(dsaList);
        
        System.out.println("Generated " + dayName + " with " + dsaList.size() + " algorithms");
    }
    
    private static int getNextDayNumber() throws IOException {
        Path srcPath = Paths.get(SRC_PATH);
        if (!Files.exists(srcPath)) {
            return 1;
        }
        
        try {
            return Files.list(srcPath)
                    .filter(Files::isDirectory)
                    .map(path -> path.getFileName().toString())
                    .filter(name -> name.startsWith("day"))
                    .mapToInt(name -> {
                        try {
                            return Integer.parseInt(name.substring(3));
                        } catch (NumberFormatException e) {
                            return 0;
                        }
                    })
                    .max()
                    .orElse(0) + 1;
        } catch (IOException e) {
            return 1;
        }
    }
    
    private static void generateClass(Path dayPath, String className, AlgorithmDef def) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("package com.kata.").append(dayPath.getFileName()).append(";\n\n");
        
        // Add imports
        sb.append("import com.kata.types.*;\n");
        sb.append("import com.kata.interfaces.*;\n");
        sb.append("import java.util.*;\n\n");
        
        // Class declaration
        sb.append("public class ").append(className);
        if (def.generic != null) {
            sb.append(def.generic);
        }
        sb.append(" {\n");
        
        // Properties
        for (Property prop : def.properties) {
            sb.append("    ").append(prop.scope).append(" ").append(prop.type).append(" ").append(prop.name).append(";\n");
        }
        
        if (!def.properties.isEmpty()) {
            sb.append("\n");
        }
        
        // Constructor
        sb.append("    public ").append(className).append("() {\n");
        sb.append("        \n");
        sb.append("    }\n");
        
        if (!def.methods.isEmpty()) {
            sb.append("\n");
        }
        
        // Methods
        for (Method method : def.methods) {
            sb.append("    public ").append(method.returnType).append(" ").append(method.name).append("(").append(method.parameters).append(") {\n");
            if (!"void".equals(method.returnType)) {
                if ("int".equals(method.returnType)) {
                    sb.append("        return 0;\n");
                } else if ("boolean".equals(method.returnType)) {
                    sb.append("        return false;\n");
                } else {
                    sb.append("        return null;\n");
                }
            }
            sb.append("    }\n\n");
        }
        
        sb.append("}\n");
        
        Files.write(dayPath.resolve(className + ".java"), sb.toString().getBytes());
    }
    
    private static void generateFunction(Path dayPath, String className, AlgorithmDef def) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("package com.kata.").append(dayPath.getFileName()).append(";\n\n");
        
        // Add imports
        sb.append("import com.kata.types.*;\n");
        sb.append("import java.util.*;\n\n");
        
        // Class with static method
        sb.append("public class ").append(className).append(" {\n");
        sb.append("    public static ").append(def.returnType).append(" ").append(def.functionName).append("(").append(def.parameters).append(") {\n");
        if (!"void".equals(def.returnType)) {
            if ("int".equals(def.returnType)) {
                sb.append("        return 0;\n");
            } else if ("boolean".equals(def.returnType)) {
                sb.append("        return false;\n");
            } else {
                sb.append("        return null;\n");
            }
        }
        sb.append("    }\n");
        sb.append("}\n");
        
        Files.write(dayPath.resolve(className + ".java"), sb.toString().getBytes());
    }
    
    private static void updatePomXml(String dayName) throws IOException {
        // Read current pom.xml
        String pomContent = Files.readString(Paths.get("pom.xml"));
        
        // Update current.day property
        pomContent = pomContent.replaceAll(
                "<current\\.day>day\\d+</current\\.day>",
                "<current.day>" + dayName + "</current.day>"
        );
        
        Files.write(Paths.get("pom.xml"), pomContent.getBytes());
    }
    
    private static void updateStats(List<String> dsaList) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Integer> stats = new HashMap<>();
        
        File statsFile = new File("stats.json");
        if (statsFile.exists()) {
            JsonNode existingStats = mapper.readTree(statsFile);
            existingStats.fieldNames().forEachRemaining(fieldName ->
                stats.put(fieldName, existingStats.get(fieldName).asInt())
            );
        }
        
        // Update stats
        for (String ds : dsaList) {
            stats.put(ds, stats.getOrDefault(ds, 0) + 1);
        }
        
        mapper.writerWithDefaultPrettyPrinter().writeValue(statsFile, stats);
    }
    
    private static void deleteDirectory(Path path) throws IOException {
        if (Files.exists(path)) {
            Files.walk(path)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        }
    }
}