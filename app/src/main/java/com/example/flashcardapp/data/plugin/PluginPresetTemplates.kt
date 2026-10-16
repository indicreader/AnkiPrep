package com.example.flashcardapp.data.plugin

data class PresetPluginTemplate(
    val id: String,
    val name: String,
    val inputType: String,
    val scriptContent: String
)

object PluginPresetTemplates {

    val RAKESH_YADAV_PDF_PARSER = PresetPluginTemplate(
        id = "rakesh_yadav_pdf_parser",
        name = "Rakesh Yadav GS PDF Parser",
        inputType = "TEXT_PDF",
        scriptContent = """
            /**
             * @manifest
             * {
             *   "id": "rakesh_yadav_pdf_parser",
             *   "name": "Rakesh Yadav GS PDF Parser",
             *   "version": "1.0.0",
             *   "author": "Community",
             *   "inputType": "TEXT_PDF",
             *   "description": "Extracts GS PYQ MCQs, handles font fixes and exam tags"
             * }
             */

            function parse(input) {
                if (!input || typeof input !== 'string') return [];
                
                // 1. Font Normalization: replace \u0018 artifact with '1'
                var cleanedText = input.replace(/\u0018/g, '1');
                
                // 2. Remove common header artifact lines
                cleanedText = cleanedText.replace(/SSC General Studies|Gaurav Sir|Page \d+/gi, '');
                
                var questions = [];
                // Split by question pattern: e.g. "1.", "13."
                var qRegex = /(?:^|\n)\s*(\d+)\.\s+([\s\S]+?)(?=\n\s*\d+\.\s+|$)/g;
                var match;
                
                while ((match = qRegex.exec(cleanedText)) !== null) {
                    var fullBlock = match[2];
                    var qNum = match[1];
                    
                    // Extract Exam Tag like [S.S.C LDC Exam, 2015]
                    var tagMatch = fullBlock.match(/\[([^\]]+)\]/);
                    var examTag = tagMatch ? tagMatch[1] : "SSC General PYQ";
                    var qTextOnly = fullBlock.replace(/\[([^\]]+)\]/g, '').trim();
                    
                    // Extract options (a), (b), (c), (d)
                    var optA = (qTextOnly.match(/\(a\)\s*([^\(]+)/i) || [])[1] || "Option A";
                    var optB = (qTextOnly.match(/\(b\)\s*([^\(]+)/i) || [])[1] || "Option B";
                    var optC = (qTextOnly.match(/\(c\)\s*([^\(]+)/i) || [])[1] || "Option C";
                    var optD = (qTextOnly.match(/\(d\)\s*([^\(]+)/i) || [])[1] || "Option D";
                    
                    // Isolate main prompt line
                    var prompt = qTextOnly.split(/\(a\)/i)[0].trim();
                    if (!prompt) prompt = "Question " + qNum;
                    
                    // Extract answer line e.g. Ans : (a) or Answer: B
                    var ansMatch = fullBlock.match(/(?:Ans|Answer)\s*[:\-]?\s*\(?([a-d1-4])\)?/i);
                    var ansLetter = "A";
                    if (ansMatch) {
                        var rawAns = ansMatch[1].toUpperCase();
                        if (rawAns === '1' || rawAns === 'A') ansLetter = 'A';
                        else if (rawAns === '2' || rawAns === 'B') ansLetter = 'B';
                        else if (rawAns === '3' || rawAns === 'C') ansLetter = 'C';
                        else if (rawAns === '4' || rawAns === 'D') ansLetter = 'D';
                    }
                    
                    questions.push({
                        question: prompt,
                        option_a: optA.trim(),
                        option_b: optB.trim(),
                        option_c: optC.trim(),
                        option_d: optD.trim(),
                        answer: ansLetter,
                        explanation: "Extracted from PYQ Booklet. Exam: " + examTag,
                        topic: "General Studies",
                        sub_topic: "PYQ Section",
                        exam_raw_tag: examTag
                    });
                }
                
                return questions;
            }
        """.trimIndent()
    )

    val RSS_ATOM_FEED_PARSER = PresetPluginTemplate(
        id = "rss_atom_feed_parser",
        name = "RSS/Atom Quiz Feed Parser",
        inputType = "RSS_ATOM",
        scriptContent = """
            /**
             * @manifest
             * {
             *   "id": "rss_atom_feed_parser",
             *   "name": "RSS/Atom Quiz Feed Parser",
             *   "version": "1.0.0",
             *   "author": "Community",
             *   "inputType": "RSS_ATOM",
             *   "description": "Converts RSS item titles & descriptions into practice quiz cards"
             * }
             */

            function parse(input) {
                if (!input || typeof input !== 'string') return [];
                var questions = [];
                
                // Simple Regex XML parser for <item> or <entry> blocks
                var itemRegex = /<(?:item|entry)[\s\S]*?>([\s\S]*?)<\/(?:item|entry)>/gi;
                var match;
                
                while ((match = itemRegex.exec(input)) !== null) {
                    var block = match[1];
                    
                    var titleMatch = block.match(/<title[^>]*>(?:<!\[CDATA\[)?([\s\S]*?)(?:\]\]>)?<\/title>/i);
                    var descMatch = block.match(/<(?:description|summary|content)[^>]*>(?:<!\[CDATA\[)?([\s\S]*?)(?:\]\]>)?<\/(?:description|summary|content)>/i);
                    
                    var title = titleMatch ? titleMatch[1].replace(/<[^>]+>/g, '').trim() : "Daily Quiz Topic";
                    var desc = descMatch ? descMatch[1].replace(/<[^>]+>/g, '').trim() : "";
                    
                    if (title.length > 5) {
                        questions.push({
                            question: title,
                            option_a: "True / Correct Statement",
                            option_b: "False / Incorrect Statement",
                            option_c: "Needs Verification",
                            option_d: "None of the above",
                            answer: "A",
                            explanation: desc.substring(0, 300) || "RSS Feed Item Content",
                            topic: "Current Affairs",
                            sub_topic: "RSS Feed",
                            exam_raw_tag: "RSS_Daily"
                        });
                    }
                }
                
                return questions;
            }
        """.trimIndent()
    )

    val HTML_WEB_SCRAPER = PresetPluginTemplate(
        id = "html_web_scraper",
        name = "Web HTML MCQ Scraper",
        inputType = "HTML_SCRAPE",
        scriptContent = """
            /**
             * @manifest
             * {
             *   "id": "html_web_scraper",
             *   "name": "Web HTML MCQ Scraper",
             *   "version": "1.0.0",
             *   "author": "Community",
             *   "inputType": "HTML_SCRAPE",
             *   "description": "Extracts questions and options from HTML web page markup"
             * }
             */

            function parse(input) {
                if (!input || typeof input !== 'string') return [];
                var questions = [];
                
                // Strip HTML tags for clean text matching
                var cleanHtml = input.replace(/<script[\s\S]*?<\/script>/gi, '')
                                     .replace(/<style[\s\S]*?<\/style>/gi, '');
                
                // Match pattern "Q1. ... Option 1 ... Option 2"
                var blocks = cleanHtml.split(/<(?:p|div|h\d)[^>]*>\s*(?:Q|Que|Question|\d+)[\:\.]/gi);
                
                for (var i = 1; i < blocks.length; i++) {
                    var text = blocks[i].replace(/<[^>]+>/g, ' ').replace(/\s+/g, ' ').trim();
                    if (text.length < 10) continue;
                    
                    questions.push({
                        question: text.substring(0, 150),
                        option_a: "Option A",
                        option_b: "Option B",
                        option_c: "Option C",
                        option_d: "Option D",
                        answer: "A",
                        explanation: "Extracted from Web HTML page",
                        topic: "Web Import",
                        sub_topic: "HTML Scraper",
                        exam_raw_tag: "Web_Scraping"
                    });
                }
                
                return questions;
            }
        """.trimIndent()
    )

    val allPresets = listOf(
        RAKESH_YADAV_PDF_PARSER,
        RSS_ATOM_FEED_PARSER,
        HTML_WEB_SCRAPER
    )
}
