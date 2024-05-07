ALTER TABLE `associate`
    ADD COLUMN address_id bigint;

ALTER TABLE `associate`
    ADD CONSTRAINT fk_associate_address
        FOREIGN KEY (address_id)
            REFERENCES `address`(id)
            ON DELETE CASCADE;
