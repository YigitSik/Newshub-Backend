INSERT INTO users (password,role,username)
VALUES ('$2a$10$7DzguvijTODCIF0uXXgxouSJVt8JAKqoCpy4l6s0.fWwVMimEP4t.','ADMIN','admin@gmail.com')
    ON CONFLICT DO NOTHING;