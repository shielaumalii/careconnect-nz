<img width="1254" height="1254" alt="image" src="https://github.com/user-attachments/assets/f1be2b1b-3641-475a-b820-3745334c6d6a" />

# CareConnect NZ

CareConnect NZ is a secure, enterprise-ready demo application for hospital clinical workflows. It is designed to showcase a modern Health Information Exchange (HIE) front-to-back integration: clinician dashboards, patient access, appointments, laboratory results, and AI-assisted clinical summarization.

[![Status](https://img.shields.io/badge/status-in%20development-orange.svg)](#)
[![Java](https://img.shields.io/badge/java-21-blue.svg)](#)
[![Spring Boot](https://img.shields.io/badge/spring--boot-4.1.0-green.svg)](#)
[![React](https://img.shields.io/badge/react-19.2.7-blue.svg)](#)

Why this project
-------------

CareConnect NZ is intended as a polished technical demo for healthcare partners. It focuses on:

- Secure handling of Protected Health Information (PHI)
- Clinician and patient workflows
- Deterministic AI summarization (source-cited, non-hallucinating by design)
- A design language suitable for enterprise hospital software

Key Highlights
--------------

- Frontend: React (Vite) + Material UI (MUI)
- Backend: Spring Boot (Java 21) + PostgreSQL
- Demo-ready UIs: Dashboard, Patients, Appointments, Lab Results, AI Insights
- Security-focused: RBAC, audit logging, encryption considerations
- Extensible: designed for future FHIR/HL7 adapters and RAG AI pipelines

Getting started (quick)
-----------------------

Prerequisites

- Java 21 and Maven
- Node.js 18+ and npm or yarn
- PostgreSQL (or use a managed DB)

Run the backend

```bash
cd backend
# configure src/main/resources/application.properties for your DB
mvn spring-boot:run
```

Run the frontend

```bash
cd careconnect-frontend
npm install
npm run dev
```

Open the frontend at the Vite URL (usually http://localhost:5173).

Development workflow
--------------------

- Use `apiClient` (Axios) for HTTP calls.
- Implement features in `src/pages/*` and reusable UI in `src/components/*`.
- Keep business logic in services and context providers under `src/services` and `src/context`.

Security & Compliance Notes
---------------------------

This repository is a demo and not production-ready by default. Before any real deployment, ensure:

- TLS for all endpoints (HTTPS)
- Authentication with httpOnly cookies or secure tokens
- Per-field or DB-level encryption for PHI
- KMS/Vault for key management and rotation
- Immutable audit logging for all accesses to clinical data
- SAST/DAST and dependency scanning enabled in CI

Architecture & Integration
--------------------------

- Typical integration points for hospitals:
	- FHIR adapter for EHR interoperability
	- HL7 interfaces where required
	- Secure VPN or private peering for network isolation

Planned Roadmap
---------------

1. Harden backend auth & RBAC
2. Build and polish Login and Dashboard pages (frontend)
3. Implement Lab Results gating, audit trails, and encrypted storage
4. Add AI Insights UI and safe RAG summarizer (with human-in-the-loop)
5. CI/CD, containerization, and staging deployment

Contributing
------------

Please open an issue or pull request. When contributing:

- Follow the established folder structure
- Add unit tests for new business logic
- Keep UI components reusable and accessible


---

CareConnect NZ — enterprise-minded demo for secure healthcare workflows.
