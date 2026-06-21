import json
import re

log_file = r'C:\Users\vijay\.gemini\antigravity-ide\brain\c68b7edc-abd5-4938-8862-34db4e9c63a8\.system_generated\logs\transcript.jsonl'

chunks = []

with open(log_file, 'r', encoding='utf-8') as f:
    for line in f:
        try:
            data = json.loads(line)
            if data.get('type') == 'PLANNER_RESPONSE':
                tool_calls = data.get('tool_calls', [])
                for tc in tool_calls:
                    if tc.get('name') in ['multi_replace_file_content', 'replace_file_content']:
                        args = tc.get('args', {})
                        target = args.get('TargetFile', '')
                        if 'DashboardTab.kt' in target:
                            for chunk in args.get('ReplacementChunks', []):
                                chunks.append(chunk.get('ReplacementContent', ''))
                    elif tc.get('name') == 'write_to_file':
                        args = tc.get('args', {})
                        target = args.get('TargetFile', '')
                        if 'DashboardTab.kt' in target:
                            chunks.append(args.get('CodeContent', ''))
        except Exception as e:
            pass

with open('dashboard_history.txt', 'w', encoding='utf-8') as f:
    for i, c in enumerate(chunks):
        f.write(f"\n--- CHUNK {i} ---\n{c}\n")
