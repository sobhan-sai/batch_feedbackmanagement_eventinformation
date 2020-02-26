DROP TABLE IF EXISTS event_information;

CREATE TABLE event_information  (
    event_id VARCHAR(100) NOT NULL PRIMARY KEY,
    base_location VARCHAR(100),
    benificiary_name VARCHAR(100),
    council_name VARCHAR(100),
    event_name VARCHAR(100),
    event_description VARCHAR(500),
    event_date VARCHAR(50),
    employee_id INT,
    employee_name VARCHAR(100),
    volunteer_hours INT,
    travel_hours FLOAT,
    lives_impacted INT,
    business_unit VARCHAR(100),
    status VARCHAR(100),
    iiep_category VARCHAR(100)
);
