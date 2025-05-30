    package com.spring.airline.Model;

    import com.spring.airline.Enums.RunwayStatus;
    import jakarta.persistence.*;


    @Entity
    public class FlightRunway {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(nullable = false )
        @Enumerated(EnumType.STRING)
        private RunwayStatus status;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public RunwayStatus getStatus() {
            return status;
        }

        public void setStatus(RunwayStatus status) {
            this.status = status;
        }
    }
