#   Title: yml_env_parser.py
#   Author: Ramirez de Diego, Jorge
#   Date: 2024
#   Code version: 1.0
#   Availability: https://github.com/JRamirezDD/TutorLink

import yaml
import os
import sys


def flatten_dict(d, parent_key='', sep='_'):
    """Flattens nested dictionaries and replaces '-' with '_' in keys."""
    items = []
    for k, v in d.items():
        # Replace '-' with '_' in the key
        new_key = f"{parent_key}{sep}{k}".replace('-', '_').upper() if parent_key else k.replace('-', '_').upper()
        if isinstance(v, dict):
            items.extend(flatten_dict(v, new_key, sep=sep).items())
        else:
            items.append((new_key, v))
    return dict(items)

def parse_yml_to_env(yml_file, output_file):
    """parses provided yml and writes env variables to output_file"""
    with open(yml_file, 'r') as f:
        config = yaml.safe_load(f)
    flattened = flatten_dict(config)
    with open(output_file, 'w') as f:
        for key, value in flattened.items():
            # write numeric values without quotes
            if isinstance(value, (int, float)) or value.isdigit():
                f.write(f'{key}={value}\n')
            else:
                f.write(f'{key}="{value}"\n')


    print(f"env variables written to {output_file}")


if len(sys.argv) != 3:
    print(f"error with args: {sys.argv}")
    sys.exit(1)
print(f"running parser with args: {sys.argv}")
parse_yml_to_env(sys.argv[1], sys.argv[2])
