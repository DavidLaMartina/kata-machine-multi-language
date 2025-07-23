package main

import (
	"encoding/json"
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

type Config struct {
	DSA []string `json:"dsa"`
}

func getNextDayNumber() (int, error) {
	entries, err := os.ReadDir(".")
	if err != nil {
		return 1, nil
	}

	var dayNumbers []int
	for _, entry := range entries {
		if entry.IsDir() && strings.HasPrefix(entry.Name(), "day") {
			numStr := strings.TrimPrefix(entry.Name(), "day")
			if num, err := strconv.Atoi(numStr); err == nil {
				dayNumbers = append(dayNumbers, num)
			}
		}
	}

	if len(dayNumbers) == 0 {
		return 1, nil
	}

	sort.Ints(dayNumbers)
	return dayNumbers[len(dayNumbers)-1] + 1, nil
}

func updateStats(dsaList []string) error {
	stats := make(map[string]int)

	// Read existing stats if they exist
	if data, err := os.ReadFile("stats.json"); err == nil {
		json.Unmarshal(data, &stats)
	}

	// Update stats
	for _, ds := range dsaList {
		stats[ds]++
	}

	// Write updated stats
	data, err := json.MarshalIndent(stats, "", "  ")
	if err != nil {
		return err
	}

	return os.WriteFile("stats.json", data, 0644)
}

func main() {
	// Read configuration
	configData, err := os.ReadFile("kata_config.json")
	if err != nil {
		fmt.Printf("Error reading config: %v\n", err)
		os.Exit(1)
	}

	var config Config
	if err := json.Unmarshal(configData, &config); err != nil {
		fmt.Printf("Error parsing config: %v\n", err)
		os.Exit(1)
	}

	// Calculate next day number
	day, err := getNextDayNumber()
	if err != nil {
		fmt.Printf("Error calculating day number: %v\n", err)
		os.Exit(1)
	}

	dayName := fmt.Sprintf("day%d", day)
	dayPath := dayName

	// Clean and create day directory
	if err := os.RemoveAll(dayPath); err != nil && !os.IsNotExist(err) {
		fmt.Printf("Error removing existing directory: %v\n", err)
		os.Exit(1)
	}

	if err := os.MkdirAll(dayPath, 0755); err != nil {
		fmt.Printf("Error creating day directory: %v\n", err)
		os.Exit(1)
	}

	// Get algorithm definitions
	definitions := getDefinitions()

	// Generate files for each algorithm
	for _, dsName := range config.DSA {
		def, exists := definitions[dsName]
		if !exists {
			fmt.Printf("Algorithm %s not found in definitions\n", dsName)
			os.Exit(1)
		}

		if def.Type == "struct" {
			if err := generateStruct(dayPath, dsName, def); err != nil {
				fmt.Printf("Error generating struct %s: %v\n", dsName, err)
				os.Exit(1)
			}
		} else {
			if err := generateFunction(dayPath, dsName, def); err != nil {
				fmt.Printf("Error generating function %s: %v\n", dsName, err)
				os.Exit(1)
			}
		}
	}

	// Update statistics
	if err := updateStats(config.DSA); err != nil {
		fmt.Printf("Error updating stats: %v\n", err)
		os.Exit(1)
	}

	fmt.Printf("Generated %s with %d algorithms\n", dayName, len(config.DSA))
}