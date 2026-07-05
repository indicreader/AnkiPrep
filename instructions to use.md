# How to Use the App & Generate Questions

This guide will explain how to set up your app for SSC CGL and how to use the Master Prompt with AI to instantly get daily questions.

## 1. Create Your Decks (Section-wise)
In the app, you can use **Subdecks** to keep everything organized. I recommend creating a master deck and putting your sections inside it. 
When creating a deck in the app, name them like this using the double colon `::` to create folders:
* `SSC CGL::English`
* `SSC CGL::Quant`
* `SSC CGL::Reasoning`
* `SSC CGL::GS`

## 2. Your Daily Workflow
1. **Generate the Questions:** Use the Master Prompt below to ask the AI to generate your 30 or 50 daily questions.
2. **Save the CSV:** Save the AI's output as a file (e.g., `english_day1.csv`).
3. **Import into the App:** 
   - Open the app and tap **Import CSV**.
   - Select your `.csv` file.
   - **Crucial Step:** When the app asks which deck to put it in, select your existing subdeck (like `SSC CGL::English`) and choose to **Merge/Update**.

---

# The AI Master Prompt

If you paste the text below into ChatGPT's "Custom Instructions" (or simply use it as your first message in a new chat), it will configure the AI. From then on, every single day, you only have to type a single keyword like **"Geometry"** or **"Active Passive Voice"**, and it will instantly spit out perfectly formatted questions.

**Copy everything inside the box below:**

```text
You are an expert SSC CGL examiner and data generator. Your sole purpose is to generate high-quality Previous Year Questions (PYQs) and Tier-1/Tier-2 level mock questions.

Whenever I give you a keyword or subject (e.g., "Algebra", "Idioms", "Polity"), you will automatically generate exactly 30 questions related to that keyword.

RULES:
1. NO CONVERSATION: Do not say "Here are your questions" or "Hope this helps". Output ONLY a single code block containing the raw CSV data.
2. EXACT CSV FORMAT: The CSV must have exactly 4 columns. Do NOT include a header row. Do NOT number the rows.
3. STRICT QUOTING: Every single column MUST be wrapped in double quotes `""`. 

COLUMN BREAKDOWN:
Column 1 (Tags): The broad subject and the specific keyword I provided (e.g., "English, Idioms").
Column 2 (Question): The exact exam-level question. 
Column 3 (Options): Exactly 4 options separated by a pipe `|`. The CORRECT answer MUST ALWAYS be the FIRST option. The remaining 3 options must be realistic "trap" distractors typical of TCS patterns.
Column 4 (Explanation): A 1-2 sentence explanation, trick, or formula to solve it.

EXAMPLE OUTPUT:
"Quant, Profit and Loss", "If the cost price of 15 articles equals the selling price of 10 articles, find the profit percentage.", "50% | 25% | 33.33% | 20%", "CP of 15 = SP of 10 -> SP/CP = 15/10 = 3/2. Profit = 1 unit on CP 2. Profit % = (1/2)*100 = 50%."
"English, Idioms", "Select the meaning of the given idiom: 'To bite the dust'", "To fail or be defeated | To clean thoroughly | To eat greedily | To start a new journey", "To bite the dust means to suffer a defeat or to die."

Awaiting my keyword...
```

---

## 💡 Important Tips for Unique Questions
* **Keep the Same Chat Open:** If you keep returning to the exact same ChatGPT thread every day and type `Geometry`, the AI remembers the questions it gave you yesterday and will naturally generate brand new ones.
* **Be Specific with Sub-Topics:** Instead of typing `Geometry` every day, type `Geometry - Focus on Triangles` or `Geometry - Focus on 3D Mensuration`.
* **Add a "Flavor" or "Year":** Type `Geometry (Focus on 2022 Tier 2 level)` to force the AI to pull from historical SSC patterns.

## 📝 Generating Full Past Papers
If you want a full historical paper (like 2017 Shift 1), do it section by section because AI has character limits.
Type: `2017 Shift 1 - Quantitative Aptitude`
Then import it into your Quant deck. 
Then type: `2017 Shift 1 - English`
And import it into your English deck.
