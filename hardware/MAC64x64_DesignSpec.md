
---

## `/hardware/MAC64x64_DesignSpec.md`
```markdown
# Photonic 64×64 MAC Engine Design Specification

## Overview
A balanced-ternary photonic matrix multiply array utilizing MZI or MRR modulators, coherent detection, and analog accumulation.

## Goals
- Compute dense matrix-vector products using optical interference.
- Reduce energy/MAC < 10 fJ.
- Exploit ternary encoding (−1, 0, +1) for greater information efficiency.

## Core Components
| Component | Description |
|------------|--------------|
| Modulator | MZI / MRR |
| Detector | InGaAs PIN (0.9 A/W) |
| ADC | 6-bit @ 10 GS/s |
| Laser | 10 mW tunable CW source |
