#!/usr/bin/env python3

import json
import os
import shutil
from pathlib import Path
from algorithm_definitions import get_definitions

def get_next_day_number():
    """Calculate the next day number based on existing day directories."""
    kata_dir = Path("kata")
    if not kata_dir.exists():
        return 1
    
    day_numbers = []
    for item in kata_dir.iterdir():
        if item.is_dir() and item.name.startswith("day"):
            try:
                day_num = int(item.name[3:])
                day_numbers.append(day_num)
            except ValueError:
                continue
    
    return max(day_numbers, default=0) + 1

def generate_class(day_path, class_name, definition):
    """Generate a Python class file."""
    lines = []
    
    # Imports
    lines.append("from typing import Optional, List, TypeVar")
    lines.append("from kata.types import *")
    lines.append("from kata.interfaces import List as ListInterface")
    lines.append("")
    
    # Generic type variable if needed
    if definition.generic:
        generic_clean = definition.generic.replace("[", "").replace("]", "")
        lines.append(f"{generic_clean} = TypeVar('{generic_clean}')")
        lines.append("")
    
    # Class definition
    class_line = f"class {class_name}"
    if definition.generic:
        class_line += f"(ListInterface{definition.generic})" if "List" in class_name else ""
    class_line += ":"
    lines.append(class_line)
    
    # Properties
    for prop in definition.properties:
        lines.append(f"    def __init__(self):")
        lines.append(f"        self.{prop.name}: {prop.type} = 0")
        lines.append("")
        break  # Only need __init__ once
    
    if not definition.properties:
        lines.append("    def __init__(self):")
        lines.append("        pass")
        lines.append("")
    
    # Methods
    for method in definition.methods:
        method_line = f"    def {method.name}(self"
        if method.parameters:
            method_line += f", {method.parameters}"
        method_line += f") -> {method.return_type}:"
        lines.append(method_line)
        
        # Default return values
        if method.return_type == "None":
            lines.append("        pass")
        elif method.return_type == "bool":
            lines.append("        return False")
        elif method.return_type == "int":
            lines.append("        return 0")
        elif "List" in method.return_type:
            lines.append("        return []")
        else:
            lines.append("        return None")
        lines.append("")
    
    # Write file
    file_path = day_path / f"{class_name}.py"
    with open(file_path, 'w') as f:
        f.write('\n'.join(lines))

def generate_function(day_path, class_name, definition):
    """Generate a Python function file."""
    lines = []
    
    # Imports
    lines.append("from typing import Optional, List")
    lines.append("from kata.types import *")
    lines.append("")
    
    # Function definition
    func_line = f"def {definition.function_name}({definition.parameters}) -> {definition.return_type}:"
    lines.append(func_line)
    
    # Default return values
    if definition.return_type == "None":
        lines.append("    pass")
    elif definition.return_type == "bool":
        lines.append("    return False")
    elif definition.return_type == "int":
        lines.append("    return -1")
    elif "List" in definition.return_type:
        lines.append("    return []")
    else:
        lines.append("    return None")
    
    # Write file
    file_path = day_path / f"{class_name}.py"
    with open(file_path, 'w') as f:
        f.write('\n'.join(lines))

def update_stats(dsa_list):
    """Update statistics file."""
    stats_file = Path("stats.json")
    stats = {}
    
    if stats_file.exists():
        with open(stats_file) as f:
            stats = json.load(f)
    
    # Update stats
    for ds in dsa_list:
        stats[ds] = stats.get(ds, 0) + 1
    
    with open(stats_file, 'w') as f:
        json.dump(stats, f, indent=2)

def main():
    # Read configuration
    with open("kata_config.json") as f:
        config = json.load(f)
    
    dsa_list = config["dsa"]
    
    # Calculate next day number
    day = get_next_day_number()
    day_name = f"day{day}"
    day_path = Path("kata") / day_name
    
    # Clean and create day directory
    if day_path.exists():
        shutil.rmtree(day_path)
    day_path.mkdir(parents=True)
    
    # Create __init__.py for the day package
    (day_path / "__init__.py").touch()
    
    # Get algorithm definitions
    definitions = get_definitions()
    
    # Generate files for each algorithm
    for ds_name in dsa_list:
        definition = definitions.get(ds_name)
        if not definition:
            raise RuntimeError(f"Algorithm {ds_name} not found in definitions")
        
        if definition.type == "class":
            generate_class(day_path, ds_name, definition)
        else:
            generate_function(day_path, ds_name, definition)
    
    # Update statistics
    update_stats(dsa_list)
    
    print(f"Generated {day_name} with {len(dsa_list)} algorithms")

if __name__ == "__main__":
    main()