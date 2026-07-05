---
name: Serene Logic
colors:
  surface: '#f9f9fc'
  surface-dim: '#dadadc'
  surface-bright: '#f9f9fc'
  surface-container-lowest: '#ffffff'
  surface-container-low: '#f3f3f6'
  surface-container: '#eeeef0'
  surface-container-high: '#e8e8ea'
  surface-container-highest: '#e2e2e5'
  on-surface: '#1a1c1e'
  on-surface-variant: '#43474f'
  inverse-surface: '#2f3133'
  inverse-on-surface: '#f0f0f3'
  outline: '#747780'
  outline-variant: '#c4c6d0'
  surface-tint: '#445f8c'
  primary: '#445f8c'
  on-primary: '#ffffff'
  primary-container: '#8faadc'
  on-primary-container: '#213e69'
  inverse-primary: '#acc7fb'
  secondary: '#4f5f7b'
  on-secondary: '#ffffff'
  secondary-container: '#cdddff'
  on-secondary-container: '#51617e'
  tertiary: '#785651'
  on-tertiary: '#ffffff'
  tertiary-container: '#c99f99'
  on-tertiary-container: '#543632'
  error: '#ba1a1a'
  on-error: '#ffffff'
  error-container: '#ffdad6'
  on-error-container: '#93000a'
  primary-fixed: '#d6e3ff'
  primary-fixed-dim: '#acc7fb'
  on-primary-fixed: '#001b3e'
  on-primary-fixed-variant: '#2b4773'
  secondary-fixed: '#d6e3ff'
  secondary-fixed-dim: '#b7c7e8'
  on-secondary-fixed: '#0a1c35'
  on-secondary-fixed-variant: '#374762'
  tertiary-fixed: '#ffdad5'
  tertiary-fixed-dim: '#e9bcb6'
  on-tertiary-fixed: '#2d1512'
  on-tertiary-fixed-variant: '#5e3f3b'
  background: '#f9f9fc'
  on-background: '#1a1c1e'
  surface-variant: '#e2e2e5'
typography:
  headline-lg:
    fontFamily: Atkinson Hyperlegible Next
    fontSize: 32px
    fontWeight: '700'
    lineHeight: 40px
    letterSpacing: 0.25px
  headline-lg-mobile:
    fontFamily: Atkinson Hyperlegible Next
    fontSize: 28px
    fontWeight: '700'
    lineHeight: 36px
  headline-md:
    fontFamily: Atkinson Hyperlegible Next
    fontSize: 24px
    fontWeight: '600'
    lineHeight: 32px
  title-lg:
    fontFamily: Atkinson Hyperlegible Next
    fontSize: 20px
    fontWeight: '600'
    lineHeight: 28px
  body-lg:
    fontFamily: Atkinson Hyperlegible Next
    fontSize: 18px
    fontWeight: '400'
    lineHeight: 28px
    letterSpacing: 0.2px
  body-md:
    fontFamily: Atkinson Hyperlegible Next
    fontSize: 16px
    fontWeight: '400'
    lineHeight: 24px
    letterSpacing: 0.5px
  label-lg:
    fontFamily: Atkinson Hyperlegible Next
    fontSize: 14px
    fontWeight: '600'
    lineHeight: 20px
    letterSpacing: 0.1px
  label-md:
    fontFamily: Atkinson Hyperlegible Next
    fontSize: 12px
    fontWeight: '500'
    lineHeight: 16px
rounded:
  sm: 0.25rem
  DEFAULT: 0.5rem
  md: 0.75rem
  lg: 1rem
  xl: 1.5rem
  full: 9999px
spacing:
  base: 8px
  xs: 4px
  sm: 8px
  md: 16px
  lg: 24px
  xl: 48px
  gutter: 16px
  margin-mobile: 16px
  margin-desktop: 32px
---

## Brand & Style

This design system is engineered for cognitive clarity and emotional regulation, specifically tailored for neurodivergent students using Obsidian for knowledge management. The brand personality is grounded, reliable, and "low-friction." 

The style merges the structural logic of Material 3 with the deep, immersive focus of Obsidian. By utilizing a "Soft-Modern" aesthetic, the interface avoids the visual "noise" that can trigger sensory overload. It prioritizes high legibility, clear spatial hierarchies, and a calming color story to foster a "Flow State" environment for ADHD and Dyslexic users.

## Colors

The palette is anchored by a sensory-friendly Periwinkle Blue (`#8FAADC`), chosen for its calming properties and sufficient contrast without being harsh. 

**Light Mode (Default):**
Uses a "Paper" strategy. Backgrounds are not pure white but a very soft, warm grey to reduce screen glare (visual stress). Primary actions use the core blue, while surfaces utilize subtle tonal variations of the neutral to define functional zones.

**Dark Mode:**
Embraces the Obsidian heritage with deep, midnight-charcoal tones (`#1A1C1E`). Rather than pure black, it uses "Deep Space" greys to prevent "halation" (where white text appears to glow or blur against black), which is critical for dyslexic readers.

**Functional Accents:**
Secondary tones are desaturated slate blues to provide organizational structure without competing for attention. The tertiary peach tone is used sparingly for highlights or "saved" states.

## Typography

The typography system exclusively uses **Atkinson Hyperlegible Next**, a typeface designed specifically for greater legibility and to help readers with low vision or cognitive differences distinguish between similar character shapes.

**Key Rules:**
1. **Line Height:** Body text maintains a generous 1.5x - 1.6x line height to prevent "line swimming" common in dyslexia.
2. **Letter Spacing:** Small increments are added to labels and body text to prevent character crowding.
3. **Hierarchy:** Large headlines are bold and clear to provide immediate landmarks for ADHD users who may skim the interface.
4. **Paragraphs:** Maximum width for body text should never exceed 70 characters to maintain reading focus.

## Layout & Spacing

The layout follows a **Fluid Grid** system based on an 8px square rhythm. This provides a predictable, logical structure that reduces visual anxiety.

- **Desktop:** 12-column grid with 24px gutters. Use wide margins (32px+) to center content and reduce peripheral distractions.
- **Tablet:** 8-column grid with 16px gutters.
- **Mobile:** 4-column grid with 16px gutters.

**Spacing Philosophy:**
Use "Whitespace as a Tool." Generous padding around text blocks (XL spacing) is required to separate distinct concepts. Avoid "wall of text" layouts; use consistent MD spacing between related items and LG spacing between unrelated sections.

## Elevation & Depth

This design system uses **Tonal Layering** rather than heavy shadows to indicate depth. This aligns with Material 3 principles while maintaining a flat, non-distracting profile.

1. **Surface Tiers:** Backgrounds are the lowest level. Containers (cards, sidebars) use a slightly lighter (in light mode) or darker (in dark mode) tint to appear "on top."
2. **Subtle Outlines:** Instead of drop shadows, use 1px "Ghost Borders" in a low-contrast neutral color. This provides clear boundaries for components without the visual weight of shadows.
3. **Active State Elevation:** Only when an element is interactive (hover/active) should a soft, ambient shadow be applied to provide a tactile "lift" sensation.

## Shapes

The shape language is defined by **ROUND_EIGHT (0.5rem / 8px)** base corner radius. This "Rounded" setting strikes a balance between professional structure and approachable softness.

- **Small Components (Buttons, Chips, Inputs):** 8px radius.
- **Medium Components (Cards, Modals):** 16px radius (`rounded-lg`).
- **Large Components (Sidebars, Sheets):** 24px radius (`rounded-xl`).

Round corners are essential for reducing the "visual sharpness" of the UI, making the environment feel more welcoming and less "clinical" for neurodivergent students.

## Components

**Buttons:**
Use high-contrast text against the Primary Blue background. Buttons must have a minimum height of 48px to ensure a large hit target. Labels are in `label-lg` for maximum clarity.

**Input Fields:**
Utilize "Filled" Material 3 style inputs with a clear 2px bottom stroke when focused. This gives students a clear landing spot for data entry. Error states must include both a color change (Soft Red) and an icon (e.g., an exclamation mark) to ensure accessibility for those with color blindness.

**Cards:**
Obsidian-style note cards should use the `rounded-lg` radius and a subtle 1px border. Background colors for cards should slightly deviate from the main surface color to denote "containment."

**Chips & Tags:**
Crucial for Obsidian's categorization. Use the Tertiary Peach or Secondary Blue with 12% opacity backgrounds and full-saturation text. This provides a clear visual category without the "visual noise" of heavy solid blocks.

**Checkboxes & Radios:**
Oversized hit areas (min 44x44px). When checked, the primary blue should fill the shape, providing an immediate, satisfying sense of task completion—an important feedback loop for ADHD productivity.