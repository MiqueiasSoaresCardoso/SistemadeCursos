package br.edu.cursosifpb.enumerate;

public enum Series {
    Primeiro_ano_medio(1),
    Segundo_ano_medio(2),
    Terceiro_ano_medio(3);
    private final int codigo;

    Series(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo(){
        return this.codigo;
    }

}
