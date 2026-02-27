CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS users (
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    user_name VARCHAR(255),
    email_id VARCHAR(255),
    created_by UUID,
    updated_by UUID,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT (now() AT TIME ZONE 'UTC'),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT (now() AT TIME ZONE 'UTC'),
    is_deleted BOOLEAN
);

CREATE TABLE IF NOT EXISTS doctors (
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    name VARCHAR(255),
    designation VARCHAR(255),
    experience DOUBLE PRECISION,
    major VARCHAR(255),
    address VARCHAR,
    about VARCHAR,
     created_by UUID,
    updated_by UUID,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT (now() AT TIME ZONE 'UTC'),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT (now() AT TIME ZONE 'UTC'),
    is_deleted BOOLEAN
);

CREATE TABLE IF NOT EXISTS clinics (
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(255),
    location VARCHAR(255),
    mobile_number VARCHAR(255),
    location_link VARCHAR,
    created_by UUID,
    updated_by UUID,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT (now() AT TIME ZONE 'UTC'),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT (now() AT TIME ZONE 'UTC'),
    is_deleted BOOLEAN
);

CREATE TABLE IF NOT EXISTS schedule_template (
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    doctor_id UUID,
    template_id UUID,
    clinic_id UUID,
    constraint_id UUID,
    day VARCHAR(255),
    day_count INTEGER,
    zero_day BOOLEAN,
    start_time TIME WITHOUT TIME ZONE,
    end_time TIME WITHOUT TIME ZONE,
    interval INTEGER,
    online_appointment BOOLEAN,
    no_of_slots INTEGER,
    bookings_left INTEGER,
    created_by UUID,
    updated_by UUID,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT (now() AT TIME ZONE 'UTC'),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT (now() AT TIME ZONE 'UTC'),
    is_deleted BOOLEAN
);

CREATE TABLE IF NOT EXISTS template (
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    template_name VARCHAR(255),
    template_id VARCHAR(255),
    doctor_id UUID,
    upload BOOLEAN,
    template_key VARCHAR(255),
    repeat_cycle INTEGER,
    clinic_id UUID,
    created_by UUID,
    updated_by UUID,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT (now() AT TIME ZONE 'UTC'),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT (now() AT TIME ZONE 'UTC'),
    is_deleted BOOLEAN
);

CREATE TABLE IF NOT EXISTS availability (
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    date DATE,
    slot VARCHAR(100),
    timeslot_start TIME,
    timeslot_end TIME,
    status VARCHAR(255),
    bookings_left INTEGER,
    template_id UUID,
    schedule_template_id UUID,
    constraint_id UUID,
    clinic_id UUID,
    doctor_id UUID,
    created_by UUID,
    updated_by UUID,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT (now() AT TIME ZONE 'UTC'),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT (now() AT TIME ZONE 'UTC'),
    is_deleted BOOLEAN
);

CREATE TABLE IF NOT EXISTS constraints (
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    key VARCHAR(255),
    name VARCHAR(255),
    colour_code VARCHAR(255),
    created_by UUID,
    updated_by UUID,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT (now() AT TIME ZONE 'UTC'),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT (now() AT TIME ZONE 'UTC'),
    is_deleted BOOLEAN
);

CREATE TABLE IF NOT EXISTS plan (
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    key VARCHAR(255),
    name VARCHAR(255),
    created_by UUID,
    updated_by UUID,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT (now() AT TIME ZONE 'UTC'),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT (now() AT TIME ZONE 'UTC'),
    is_deleted BOOLEAN
);

CREATE TABLE IF NOT EXISTS reasons (
    id UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    reason VARCHAR(255),
    created_by UUID,
    updated_by UUID,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT (now() AT TIME ZONE 'UTC'),
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT (now() AT TIME ZONE 'UTC'),
    is_deleted BOOLEAN
);

CREATE TABLE IF NOT EXISTS master_data (
    id BIGSERIAL PRIMARY KEY,
    key VARCHAR(255),
    value VARCHAR(255)
);