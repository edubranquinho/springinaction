package br.com.branquinho.tacocloud.papoReto;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

public class Empresa {

    String nome;
    Collection<Funcionario> funcionarios = new HashSet<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void registraFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public Collection<Funcionario> listaFuncionarios() {
        return Collections.unmodifiableCollection(funcionarios);
    }

    public boolean emprega(Funcionario funcionario) {
        return funcionarios.contains(funcionario);
    }
}
