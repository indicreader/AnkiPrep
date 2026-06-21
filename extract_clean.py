import json

log_file = r'C:\Users\vijay\.gemini\antigravity-ide\brain\c68b7edc-abd5-4938-8862-34db4e9c63a8\.system_generated\logs\transcript.jsonl'

dashboard_content = None

with open(log_file, 'r', encoding='utf-8') as f:
    for line in f:
        try:
            data = json.loads(line)
            if data.get('type') == 'PLANNER_RESPONSE':
                step = data.get('step_index', 0)
                if step < 7700:  # earlier steps
                    tool_calls = data.get('tool_calls', [])
                    for tc in tool_calls:
                        if tc.get('name') in ['multi_replace_file_content', 'replace_file_content', 'write_to_file']:
                            args = tc.get('args', {})
                            target = args.get('TargetFile', '')
                            content = ''
                            if tc.get('name') == 'write_to_file':
                                content = args.get('CodeContent', '')
                            else:
                                chunks = args.get('ReplacementChunks', [])
                                if chunks:
                                    content = chunks[0].get('ReplacementContent', '')
                            
                            if 'DashboardTab.kt' in target and len(content) > 3000:
                                dashboard_content = content
        except Exception as e:
            pass

if dashboard_content:
    with open('recovered_dashboard_clean.kt', 'w', encoding='utf-8') as f:
        f.write(dashboard_content)
    print(f'Recovered DashboardTab.kt! length {len(dashboard_content)}')
