// package br.fatec.labiv.Project_LAB4.entity;

// import java.util.List;

// import com.fasterxml.jackson.annotation.JsonIgnore;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinTable;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToMany;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.Table;
// import lombok.AllArgsConstructor;
// import lombok.Getter;
// import lombok.Setter;

// @AllArgsConstructor
// @Getter
// @Setter
// @Entity
// @Table(name = "usr_usuario")
// public class Usuario {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     @Column (name = "usr_id")
//     private Long id;
    
//     @Column(name = "usr_nome")
//     private String nome;

//     @Column(name = "usr_senha")
//     private String senha;

//     @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
//     @JsonIgnore
//     private List<Anotacao> anotacoes;
   
//     @ManyToMany
//     @JoinTable(name = "uau_usuario_autorizacao",
//     joinColumns = {@JoinColumn(name = "usr_id")},
//     inverseJoinColumns = {@JoinColumn(name = "aut_id")})
//     private List<Autorizacao> autorizacoes;
    
//     public Usuario(){}

// }
