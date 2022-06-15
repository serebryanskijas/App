package com.example.springthymeleafupload.smart;

import com.example.springthymeleafupload.firm.Firm;
import com.example.springthymeleafupload.os.Os;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity

public class Smart {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "firm_id", referencedColumnName = "id")
    private Firm firm;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "os_id", referencedColumnName = "id")
    private Os os;
    private double size;
    private String color;
}
