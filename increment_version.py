import re
import os

gradle_file = 'app/build.gradle.kts'

def increment_version():
    with open(gradle_file, 'r', encoding='utf-8') as file:
        content = file.read()

    # Find versionCode
    code_match = re.search(r'versionCode\s*=\s*(\d+)', content)
    # Find versionName
    name_match = re.search(r'versionName\s*=\s*"([\d\.]+)"', content)

    if code_match and name_match:
        current_code = int(code_match.group(1))
        current_name_str = name_match.group(1)
        
        # Parse version name
        if '.' in current_name_str:
            parts = current_name_str.split('.')
            try:
                major = int(parts[0])
                minor = int(parts[1])
            except ValueError:
                print(f"Could not parse parts of versionName {current_name_str}")
                return
        else:
            try:
                major = int(current_name_str)
                minor = 0
            except ValueError:
                print(f"Could not parse versionName {current_name_str} as integer")
                return

        new_code = current_code + 1
        
        # Increment logic
        minor += 1
        if minor >= 100:
            major += 1
            minor = 0
            
        if minor == 0:
            new_name_str = f"{major}"
        else:
            new_name_str = f"{major}.{minor}"

        # Replace in content
        content = re.sub(
            r'versionCode\s*=\s*\d+',
            f'versionCode = {new_code}',
            content
        )
        content = re.sub(
            r'versionName\s*=\s*"[\d\.]+"',
            f'versionName = "{new_name_str}"',
            content
        )

        with open(gradle_file, 'w', encoding='utf-8') as file:
            file.write(content)
            
        print(f"Incremented version to {new_name_str} (Code {new_code})")
    else:
        print("Could not find versionCode or versionName in build.gradle.kts")

if __name__ == "__main__":
    increment_version()
