---
name: Obsidian Bookshelf
colors:
  surface: '#121416'
  surface-dim: '#121416'
  surface-bright: '#37393b'
  surface-container-lowest: '#0c0e10'
  surface-container-low: '#1a1c1e'
  surface-container: '#1e2022'
  surface-container-high: '#282a2c'
  surface-container-highest: '#333537'
  on-surface: '#e2e2e5'
  on-surface-variant: '#c4c6d0'
  inverse-surface: '#e2e2e5'
  inverse-on-surface: '#2f3133'
  outline: '#8e909a'
  outline-variant: '#43474f'
  surface-tint: '#acc7fb'
  primary: '#acc7fb'
  on-primary: '#10305b'
  primary-container: '#8faadc'
  on-primary-container: '#213e69'
  inverse-primary: '#445f8c'
  secondary: '#81d4d4'
  on-secondary: '#003737'
  secondary-container: '#006f6f'
  on-secondary-container: '#9aefee'
  tertiary: '#cebdff'
  on-tertiary: '#381385'
  tertiary-container: '#b39aff'
  on-tertiary-container: '#462793'
  error: '#ffb4ab'
  on-error: '#690005'
  error-container: '#93000a'
  on-error-container: '#ffdad6'
  primary-fixed: '#d6e3ff'
  primary-fixed-dim: '#acc7fb'
  on-primary-fixed: '#001b3e'
  on-primary-fixed-variant: '#2b4773'
  secondary-fixed: '#9df1f1'
  secondary-fixed-dim: '#81d4d4'
  on-secondary-fixed: '#002020'
  on-secondary-fixed-variant: '#004f50'
  tertiary-fixed: '#e8ddff'
  tertiary-fixed-dim: '#cebdff'
  on-tertiary-fixed: '#21005e'
  on-tertiary-fixed-variant: '#4f319c'
  background: '#121416'
  on-background: '#e2e2e5'
  surface-variant: '#333537'
  obsidian-base: '#0F1113'
  surface-charcoal: '#1A1C1E'
  surface-elevated: '#282A2D'
  soft-indigo: '#8FAADC'
  muted-teal: '#6BBFBF'
  reading-gray: '#E2E2E6'
  error-rose: '#F2B8B5'
typography:
  display-lg:
    fontFamily: Atkinson Hyperlegible Next
    fontSize: 45px
    fontWeight: '700'
    lineHeight: 52px
    letterSpacing: -0.02em
  headline-lg:
    fontFamily: Atkinson Hyperlegible Next
    fontSize: 32px
    fontWeight: '600'
    lineHeight: 40px
  headline-lg-mobile:
    fontFamily: Atkinson Hyperlegible Next
    fontSize: 28px
    fontWeight: '600'
    lineHeight: 36px
  title-lg:
    fontFamily: Atkinson Hyperlegible Next
    fontSize: 22px
    fontWeight: '500'
    lineHeight: 28px
  body-lg:
    fontFamily: Atkinson Hyperlegible Next
    fontSize: 18px
    fontWeight: '400'
    lineHeight: 32px
    letterSpacing: 0.01em
  body-md:
    fontFamily: Atkinson Hyperlegible Next
    fontSize: 16px
    fontWeight: '400'
    lineHeight: 28px
  label-lg:
    fontFamily: Atkinson Hyperlegible Next
    fontSize: 14px
    fontWeight: '600'
    lineHeight: 20px
    letterSpacing: 0.1em
rounded:
  sm: 0.25rem
  DEFAULT: 0.5rem
  md: 0.75rem
  lg: 1rem
  xl: 1.5rem
  full: 9999px
spacing:
  shelf-gap: 2rem
  container-padding: 1.5rem
  gutter: 1rem
  stack-sm: 0.5rem
  stack-md: 1rem
  stack-lg: 1.5rem
---

## Brand & Style
The design system is built on a "Bookshelf" metaphor, transforming a high-stakes exam environment into a calm, organized library of knowledge. It merges the structured logic of **Material 3 (M3)** with the focused, high-contrast aesthetic of **Obsidian**, specifically tailored for neurodivergent accessibility (ADHD/Dyslexia).

The brand personality is **Studious, Calm, and Intentional**. It avoids the "gamification" fatigue of bright neon streaks in favor of deep, stable foundations.

### Style Principles
- **Material 3 Foundation:** Uses M3’s containment, iconography, and state layers but replaces the default pastel palette with deeper, more grounded tones.
- **Minimalist Depth:** High contrast for readability without the harshness of pure black/white. Surfaces use subtle tonal shifts rather than heavy shadows to indicate hierarchy.
- **Low-Stimulus Motion:** Transitions are purposeful and slow (300ms+), using "ease-out" curves to prevent jarring shifts that trigger ADHD distractibility.
- **Cognitive Ease:** Generous whitespace (macro-gutters) separates the "books" (decks) to prevent visual crowding.

## Colors
The palette is optimized for long-duration study sessions. It utilizes a **Dark Mode Default** to reduce eye strain and light sensitivity.

- **Primary (Soft Indigo):** Used for the main action buttons and active "book" states. It provides high visibility against charcoal backgrounds without the vibrating energy of pure blue.
- **Secondary (Muted Teal):** Dedicated to progress indicators and "correct" states. Teal is chosen for its calming properties compared to aggressive greens.
- **Neutral (Obsidian & Charcoal):** The background is not pure black (`#000000`), which can cause "halation" effects for dyslexic readers. Instead, it uses a deep `#0F1113` base.
- **Semantic Logic:**
    - **Neutral Surface:** Deep charcoals for container backgrounds.
    - **On-Surface Text:** Soft off-white (`#E2E2E6`) to reduce the high-contrast "flicker" often experienced by neurodivergent users.

## Typography
The system exclusively uses **Atkinson Hyperlegible Next**. This font is specifically designed to increase character recognition and reduce misreading, which is critical for medical or technical MCQ exams.

### Typographic Rules:
- **Line Spacing:** Body text uses a generous `1.6x` to `1.8x` line height (32px for 18px text). This prevents "line swimming" where the eye loses its place.
- **Paragraph Spacing:** Double the standard margin between question text and options to provide clear mental "breathing room."
- **Letter Spacing:** Labels use increased tracking (0.1em) to ensure all-caps or small-scale text remains legible.
- **Emphasis:** Avoid italics, which can be difficult for dyslexic readers. Use **Bold** or Tonal highlighting (Primary color) for emphasis.

## Layout & Spacing
The layout follows a **Fixed-Width Fluid** model. Content is centered on a maximum 800px column for desktop to minimize eye travel distance.

### The Bookshelf Grid
- **The "Shelf":** Decks are displayed in a vertical stack or a 2-column grid on tablet/desktop, resembling spines on a shelf.
- **Margins:** A 24px (1.5rem) safety margin is maintained on all edges to prevent the UI from feeling "crowded" against the device bezel.
- **Vertical Rhythm:** A strict 8px base unit is used. MCQ options are separated by 12px (0.75rem) to ensure they are distinct "tap targets" for those with motor-control or focus challenges.
- **Breakpoints:**
  - **Mobile (<600px):** Single column, bottom-anchored primary actions.
  - **Tablet (600px - 1024px):** 2-column "Shelf" view for decks.
  - **Desktop (>1024px):** Centered reading column (max-width: 800px) with side-rail navigation.

## Elevation & Depth
In line with the Obsidian influence, depth is communicated through **Tonal Layering** rather than traditional drop shadows.

- **Level 0 (Background):** `#0F1113` - The "room" behind the bookshelf.
- **Level 1 (Decks/Cards):** `#1A1C1E` - The primary surface for content containers.
- **Level 2 (Active/Hover):** `#282A2D` - Subtle elevation for interactive elements.
- **Stroke-over-Shadow:** Instead of blurry shadows, elements use a 1px solid border in a slightly lighter charcoal (`#35373A`) to define edges. This provides the crispness required for high-contrast accessibility without visual "fuzziness."
- **Active State:** When an MCQ option is selected, it should utilize a 2px interior stroke of the `primary_color` (Soft Indigo).

## Shapes
Following Material 3 standards, shapes are friendly and rounded to counteract the "coldness" of the dark charcoal palette.

- **Containers (Decks/Question Cards):** Use `rounded-xl` (1.5rem) to create a distinct, soft container for information.
- **Buttons & MCQ Options:** Use `rounded-lg` (1rem). The slightly squarer shape compared to full pills provides more surface area for text-heavy MCQ options.
- **Inputs:** Use `rounded-md` (0.5rem) to maintain a systematic, functional feel.

## Components

### Bookshelf Decks (Cards)
Decks should appear as thick horizontal cards. Left-hand accent borders (4px wide) in the `primary` or `tertiary` color distinguish between different subjects. Include a "Last Reviewed" label in the `label-lg` style.

### MCQ Options
- **Default State:** Charcoal surface, 1px subtle border, `body-lg` text.
- **Selected State:** Soft Indigo background (20% opacity), 2px Indigo border.
- **Correct State:** Muted Teal background (20% opacity), 2px Teal border.
- **Incorrect State:** Error Rose background (20% opacity), 2px Rose border.
- **Interaction:** Increase the surface brightness (`surface-elevated`) on hover/touch to provide immediate feedback.

### Buttons
- **Primary:** Filled with `primary_color`, text in `obsidian-base`. Large tap targets (minimum 56px height).
- **Secondary:** Outlined with `secondary_color`. Used for "Back" or "Skip" actions.
- **Review Buttons (FSRS):** Four equal-width buttons at the bottom of the screen. Use tonal backgrounds (Again = Rose, Hard = Gray, Good = Teal, Easy = Indigo) but keep the saturation low to avoid overstimulation.

### Progress Indicators
Use a "Thin Line" progress bar at the very top of the screen (4px height). It should use `secondary_color` to track the current quiz progress. Avoid "pulsing" or "shimmer" animations; use simple linear fills.

### Navigation
A bottom navigation bar (M3 style) for "Bookshelf" (Home), "Analytics," and "Settings." Use active-state "pills" around the icons in the `primary_color`.