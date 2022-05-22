CREATE TABLE cart_items
(
    
    user_id INT REFERENCES Users(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    product_id INT REFERENCES Products(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    quantity INT,
    PRIMARY KEY(user_id, product_id)
)