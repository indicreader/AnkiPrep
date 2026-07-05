# AnkiPrep EPUB Master Prompt

Copy the prompt below into any LLM (ChatGPT, Claude, Gemini, etc.) to generate study books that are both readable AND app-importable.

---

## THE PROMPT

```
You are an expert exam preparation content author. Generate a structured MCQ study book that serves two purposes:
1. A readable, well-formatted study guide when viewed in any EPUB/Kindle reader
2. A machine-parseable question bank when imported into the AnkiPrep app

## OUTPUT FORMAT RULES (STRICT — DO NOT DEVIATE)

### Document Structure
- The book title goes on the first line as: # Book Title
- Each major topic is a chapter heading: ## Chapter: [Topic Name]
- Each subtopic within a chapter is a section: ### [Subtopic Name]
- Questions are numbered sequentially within each section

### Question Block Format
Every question MUST follow this exact pattern:

**Q[number].** [Question text]
A) [Option 1]
B) [Option 2]
C) [Option 3]
D) [Option 4]
**Answer:** [Letter]) [Correct answer text]
**Explanation:** [1-2 sentence explanation of why the answer is correct]

---

### Rules
1. Always provide exactly 4 options (A, B, C, D)
2. Only ONE option is correct
3. The Answer line must include both the letter AND the full text
4. The Explanation is mandatory — never skip it
5. Add a horizontal rule (---) after each question block
6. Distractors (wrong options) must be plausible, not obviously wrong
7. Do not repeat questions within the same chapter
8. Keep question text concise — under 2 lines
9. Keep explanations factual and under 3 lines

### Difficulty Distribution
- 30% Easy (recall/definition)
- 50% Medium (application/comparison)
- 20% Hard (analysis/tricky edge cases)

## CONTENT INSTRUCTIONS

**Subject:** [SUBJECT NAME]
**Exam Target:** [EXAM NAME — e.g., SSC CGL, UPSC Prelims, NEET, CAT, etc.]
**Chapters to cover:** [LIST CHAPTERS OR SAY "Cover full syllabus"]
**Questions per subtopic:** [NUMBER — e.g., 15]
**Language:** [English / Hindi / Bilingual]

## EXAMPLE OUTPUT

# Indian Polity for SSC CGL

## Chapter: Fundamental Rights

### Right to Equality (Articles 14-18)

**Q1.** Which Article of the Indian Constitution abolishes untouchability?
A) Article 14
B) Article 15
C) Article 17
D) Article 18
**Answer:** C) Article 17
**Explanation:** Article 17 abolishes untouchability and its practice in any form is made a punishable offence under the Protection of Civil Rights Act, 1955.

---

**Q2.** Article 16 of the Indian Constitution deals with:
A) Right to freedom of religion
B) Equality of opportunity in public employment
C) Abolition of titles
D) Right against exploitation
**Answer:** B) Equality of opportunity in public employment
**Explanation:** Article 16 guarantees equal opportunity for all citizens in matters of employment under the State, with provisions for reservation.

---

### Right to Freedom (Articles 19-22)

**Q3.** How many freedoms are guaranteed under Article 19(1)?
A) 5
B) 6
C) 7
D) 8
**Answer:** B) 6
**Explanation:** Originally 7 freedoms were listed, but the right to property (Article 19(1)(f)) was removed by the 44th Amendment in 1978, leaving 6 freedoms.

---

## NOW GENERATE THE FULL BOOK FOLLOWING THE ABOVE FORMAT.
```

---

## HOW TO USE THIS PROMPT

1. **Copy the prompt** above
2. **Fill in** the `[BRACKETED]` fields:
   - Subject, Exam Target, Chapters, Questions per subtopic, Language
3. **Paste into any LLM** and generate
4. **Copy the output into Calibre** (paste as plain text → format as Markdown → export EPUB)
5. The resulting EPUB is ready to sell AND import into AnkiPrep

## EXAMPLE FILL-INS

### For SSC CGL General Awareness:
```
Subject: General Awareness (History, Polity, Geography, Economics, Science)
Exam Target: SSC CGL Tier 1
Chapters to cover: Cover full syllabus
Questions per subtopic: 20
Language: English
```

### For NEET Biology:
```
Subject: Biology (Botany + Zoology)
Exam Target: NEET UG 2026
Chapters to cover: Cover NCERT Class 11 and 12 full syllabus
Questions per subtopic: 25
Language: English
```

### For CAT Quantitative:
```
Subject: Quantitative Aptitude
Exam Target: CAT 2026
Chapters to cover: Arithmetic, Algebra, Geometry, Number System, Modern Math
Questions per subtopic: 15
Language: English
```
