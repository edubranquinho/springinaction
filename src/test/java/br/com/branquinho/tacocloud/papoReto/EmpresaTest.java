package br.com.branquinho.tacocloud.papoReto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpresaTest {

    @Test
    public void deveBuscarFuncionarioCorretamente() {
        Funcionario branquinho = new Funcionario();
        branquinho.setNome("Eduardo");
        branquinho.setCpf("123456");
        branquinho.setCargo("Desenvolvedor");

        Empresa bluesoft = new Empresa();
        bluesoft.registraFuncionario(branquinho);

        ///outro canto do sistema quer saber se Eduardo trabalha na Bluesoft

        Funcionario funcionarioBusca = new Funcionario();
        funcionarioBusca.setNome("Eduardo");
        funcionarioBusca.setCpf("123456");
        funcionarioBusca.setCargo("Desenvolvedor");

        assertTrue(bluesoft.emprega(funcionarioBusca));
    }
}