    package com.spring.airline.Model;

    import jakarta.persistence.*;

    import java.util.List;

    @Entity
    public class User extends Person {

        @Column(nullable = false , unique = true , length = 50)
        private String username;

        @Column(nullable = false , unique=true , length = 50)
        private String password;

        // it's optional (don't add any field to table)
        @OneToMany(mappedBy = "user")
        private List<Ticket> tickets;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public List<Ticket> getTickets() {
            return tickets;
        }

        public void setTickets(List<Ticket> tickets) {
            this.tickets = tickets;
        }


    }

