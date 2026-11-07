# LedgerLine - AI Prompts & Engineering Log

## Date: November 6, 2026
* **Commit Link:** Initial commit
* **What I Asked:** Asked AI for project structure and initial setup guidelines for LedgerLine backend.
* **What the AI Produced:** Suggested a basic folder structure with standard configuration files.
* **What Was Wrong / Risk:** The AI structure lacked explicit separation for security configs and double-entry validation layers.
* **What I Did Instead:** Organized the package structure into dedicated packages (`model`, `repository`, `service`, `controller`, `config`) to maintain clean architecture.

## Day 2: Domain Modeling & Double-Entry Bookkeeping
- **Prompt/Goal:** Implemented core financial domain entities (`Transaction` and `LedgerEntry`) adhering to strict double-entry accounting standards and `BigDecimal` precision.
- **Architectural Notes:** 
  - Added a unique reference/idempotency key field in `Transaction` to prevent duplicate processing from network retries.
  - Linked `LedgerEntry` with `DEBIT` and `CREDIT` types mapping back to specific accounts.