package br.edu.cursosifpb.enumerate;

public enum Bimestres {
    Primeiro_Bimestre(1),
    Segundo_Bimestre(2),
    Terceiro_Bimestre(3);

    private int codigo;

    Bimestres (int codigo){
        this.codigo = codigo;
    }
    public int getCodigo() {
        return codigo;
    }
}
