-- Schema definition for ormlearn database

-- Country Table
CREATE TABLE IF NOT EXISTS country (
  co_code VARCHAR(2) PRIMARY KEY,
  co_name VARCHAR(50) NOT NULL
);

-- Stock Table
CREATE TABLE IF NOT EXISTS stock (
  st_id INT AUTO_INCREMENT PRIMARY KEY,
  st_code VARCHAR(10) NOT NULL,
  st_date DATE NOT NULL,
  st_open NUMERIC(10,2) NOT NULL,
  st_close NUMERIC(10,2) NOT NULL,
  st_volume BIGINT NOT NULL
);

-- Department Table
CREATE TABLE IF NOT EXISTS department (
  dp_id INT AUTO_INCREMENT PRIMARY KEY,
  dp_name VARCHAR(50) NOT NULL
);

-- Employee Table
CREATE TABLE IF NOT EXISTS employee (
  em_id INT AUTO_INCREMENT PRIMARY KEY,
  em_name VARCHAR(50) NOT NULL,
  em_salary NUMERIC(10,2) NOT NULL,
  em_permanent BOOLEAN NOT NULL,
  em_date_of_birth DATE,
  em_dp_id INT,
  FOREIGN KEY (em_dp_id) REFERENCES department(dp_id)
);

-- Skill Table
CREATE TABLE IF NOT EXISTS skill (
  sk_id INT AUTO_INCREMENT PRIMARY KEY,
  sk_name VARCHAR(50) NOT NULL
);

-- Employee Skill Mapping Table
CREATE TABLE IF NOT EXISTS employee_skill (
  es_id INT AUTO_INCREMENT PRIMARY KEY,
  es_em_id INT NOT NULL,
  es_sk_id INT NOT NULL,
  FOREIGN KEY (es_em_id) REFERENCES employee(em_id),
  FOREIGN KEY (es_sk_id) REFERENCES skill(sk_id)
);

-- Quiz Tables
CREATE TABLE IF NOT EXISTS users (
  us_id INT AUTO_INCREMENT PRIMARY KEY,
  us_name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS question (
  qn_id INT AUTO_INCREMENT PRIMARY KEY,
  qn_text VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS options (
  op_id INT AUTO_INCREMENT PRIMARY KEY,
  op_qn_id INT NOT NULL,
  op_text VARCHAR(255) NOT NULL,
  op_score NUMERIC(3,1) NOT NULL,
  op_is_correct BOOLEAN NOT NULL,
  FOREIGN KEY (op_qn_id) REFERENCES question(qn_id)
);

CREATE TABLE IF NOT EXISTS attempt (
  at_id INT AUTO_INCREMENT PRIMARY KEY,
  at_us_id INT NOT NULL,
  at_date DATE NOT NULL,
  FOREIGN KEY (at_us_id) REFERENCES users(us_id)
);

CREATE TABLE IF NOT EXISTS attempt_question (
  aq_id INT AUTO_INCREMENT PRIMARY KEY,
  aq_at_id INT NOT NULL,
  aq_qn_id INT NOT NULL,
  FOREIGN KEY (aq_at_id) REFERENCES attempt(at_id),
  FOREIGN KEY (aq_qn_id) REFERENCES question(qn_id)
);

CREATE TABLE IF NOT EXISTS attempt_option (
  ao_id INT AUTO_INCREMENT PRIMARY KEY,
  ao_aq_id INT NOT NULL,
  ao_op_id INT NOT NULL,
  ao_is_selected BOOLEAN NOT NULL,
  FOREIGN KEY (ao_aq_id) REFERENCES attempt_question(aq_id),
  FOREIGN KEY (ao_op_id) REFERENCES options(op_id)
);
