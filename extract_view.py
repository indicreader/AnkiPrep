import json

log_file = r'C:\Users\vijay\.gemini\antigravity-ide\brain\c68b7edc-abd5-4938-8862-34db4e9c63a8\.system_generated\logs\transcript.jsonl'

with open(log_file, 'r', encoding='utf-8') as f:
    for line in f:
        try:
            data = json.loads(line)
            if data.get('type') == 'VIEW_FILE_RESULT' or data.get('type') == 'TOOL_RESPONSE':
                # Sometimes it's in the content or output
                content = data.get('content', '')
                if 'DashboardTab.kt' in content and 'fun DashboardTab' in content:
                    print(f"Found view_file at step {data.get('step_index')}, len {len(content)}")
        except Exception as e:
            pass
