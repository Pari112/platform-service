-- Seed departments and ticket types for QMS platform-service
-- Departments
INSERT INTO departments (code, name, description, active, created_at, updated_at) VALUES
('HOSTEL', 'Hostel', 'Hostel related requests (rooms, facilities, maintenance)', true, now(), now()),
('HEALTH', 'Health', 'Health centre and medical assistance requests', true, now(), now()),
('ADMISSION', 'Admission', 'Admission related queries and documentation', true, now(), now());

-- Ticket types for HOSTEL
INSERT INTO ticket_types (code, department_code, name, description, sla_minutes, default_priority, active, created_at, updated_at) VALUES
('ROOM_MAINTENANCE', 'HOSTEL', 'Room Maintenance', 'Issues like leaking, electrical faults, carpentry', 1440, 'MEDIUM', true, now(), now()),
('FACILITY_REQUEST', 'HOSTEL', 'Facility Request', 'Requests for furniture, bedding, housekeeping', 2880, 'LOW', true, now(), now());

-- Ticket types for HEALTH
INSERT INTO ticket_types (code, department_code, name, description, sla_minutes, default_priority, active, created_at, updated_at) VALUES
('MEDICAL_CONSULT', 'HEALTH', 'Medical Consultation', 'Request for doctor consultation or first aid', 240, 'HIGH', true, now(), now()),
('VACCINATION', 'HEALTH', 'Vaccination', 'Requests for vaccination drives or certificates', 1440, 'MEDIUM', true, now(), now());

-- Ticket types for ADMISSION
INSERT INTO ticket_types (code, department_code, name, description, sla_minutes, default_priority, active, created_at, updated_at) VALUES
('DOCUMENT_SUBMISSION', 'ADMISSION', 'Document Submission', 'Submission or query about admission documents', 10080, 'LOW', true, now(), now()),
('ADMISSION_QUERY', 'ADMISSION', 'Admission Query', 'General questions about admission process', 4320, 'MEDIUM', true, now(), now());
