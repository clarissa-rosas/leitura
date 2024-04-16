package projetoLivro;

public class Leitura {
    public static void main(String[] args) {

        //Pessoas

        Pessoa[] p = new Pessoa[4];
        p[0] = new Pessoa("Ana",22, "F");
        p[1] = new Pessoa("João", 28, "M");
        p[2] = new Pessoa("Maria", 33, "F");
        p[3] = new Pessoa("Luiza", 29, "F");

        //Livros

        Livro[] l = new Livro[4];
        l[0] = new Livro("'Meio sol amarelo'", "Chimamanda Ngozi Adichie", 504);
        l[1] = new Livro("'Spinoza sem saída'", "Luiz Alfredo Garcia-Roza", 216);
        l[2] = new Livro("'Uma leve simetria'", "Rafael Bán Jacobsen", 224);
        l[3] = new Livro("'Jane Eyre'", "Charlotte Brontë",480);

        //Ações

        System.out.println("--------------------------------------------");
        System.out.println("##### LISTA DE PESSOAS CADASTRADAS #####");
        System.out.println("--------------------------------------------");
        for (Pessoa pessoa : p) {
            System.out.println(pessoa.informacoes());
        }

        System.out.println("--------------------------------------------");
        System.out.println("##### LISTA DE LIVROS CADASTRADOS#####");
        System.out.println("--------------------------------------------");
        for (Livro livro : l) {
            System.out.println(livro.informacoes());
        }

        l[0].setLeitor(p[2]);
        l[1].setLeitor(p[3]);
        l[2].setLeitor(p[1]);
        l[3].setLeitor(p[0]);

        l[0].setPagAtual(226);
        l[1].setPagAtual(143);
        l[2].setPagAtual(84);
        l[3].setPagAtual(115);

        System.out.println("--------------------------------------------");
        System.out.println("##### OPERAÇÕES GERAIS #####");
        System.out.println("--------------------------------------------");
        for (Livro livro : l) {
            livro.detalhar();
        }

        for (Livro livro : l) {
            livro.abrir();
        }

        l[0].folhear(25);
        l[1].folhear(90);
        l[2].passarPag();
        l[3].voltarPag();

        for (Pessoa pessoa : p) {
            pessoa.fazerAniversario();
        }

        System.out.println("--------------------------------------------");
        System.out.println("##### ESTADOS FINAIS #####");
        System.out.println("--------------------------------------------");
        for (Livro livro : l) {
            livro.detalhar();
        }
        System.out.println("--------------------------------------------");
    }
}