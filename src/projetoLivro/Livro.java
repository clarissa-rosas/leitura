package projetoLivro;

public class Livro implements Publicacao {

    //Atributos

    private String titulo;
    private String autor;
    private int totalPag;
    private int pagAtual;
    private boolean aberto;
    private boolean fechado;
    private String estado;
    private Pessoa leitor;
    private Pessoa nenhum;

    public String informacoes() {
        if (leitor != null) {
            return "Livro{" +
                    "titulo='" + titulo + '\'' +
                    ", autor='" + autor + '\'' +
                    ", totalPag=" + totalPag + '\'' +
                    ", pagAtual=" + pagAtual + '\'' +
                    ", aberto=" + aberto + '\'' +
                    ", leitor=" + leitor.getNome() + '\'' +
                    ", idade=" + leitor.getIdade() + '\'' +
                    ", sexo=" + leitor.getSexo() + "}";
        } else {
            return "Livro{" +
                    "titulo='" + titulo + '\'' +
                    ", autor='" + autor + '\'' +
                    ", totalPag=" + totalPag + '\'' +
                    ", pagAtual=" + pagAtual + '\'' +
                    ", aberto=" + aberto + '\'' +
                    ", leitor=" + nenhum + "}";
        }

    }

    public Livro(String titulo, String autor, int totalPag) {
        this.titulo = titulo;
        this.autor = autor;
        this.totalPag = totalPag;
        this.aberto = false;
        this.pagAtual = 0;
    }

    //Métodos acessores

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getTotalPag() {
        return totalPag;
    }

    public void setTotalPag(int totalPag) {
        this.totalPag = totalPag;
    }

    public int getPagAtual() {
        return pagAtual;
    }

    public void setPagAtual(int pagAtual) {
        if (pagAtual <= totalPag) {
            this.pagAtual = pagAtual;
        } else {
            this.pagAtual = 0;
        }
    }

    public void setLeitor(Pessoa leitor) {
        this.leitor = leitor;
    }

    public boolean getAberto() {
        return aberto;
    }

    public void setAberto () {
        this.aberto = aberto;
    }

    public void setLeitor (Pessoa leitor, String titulo){
        this.leitor = leitor;
        this.titulo = titulo;
    }

    public Pessoa getLeitor () {
        if (leitor != null) {
            return leitor;
        } else {
            System.out.println("Ainda não foi atribuído um leitor para este livro!");
            return nenhum;
        }
    }

    public String getEstado() {
        if (getAberto()) {
            return "aberto";
        } else {
            return "fechado";
        }
    }

    //Métodos principais

    public void detalhar() {
        System.out.println("O livro intitula-se " + getTitulo() + " e foi escrito por " + getAutor() + ".");
        System.out.println("Tem " + getTotalPag() + " páginas e está " + getEstado() + ". "
                + getLeitor().getNome() + " tem " + getLeitor().getIdade() + " anos e está na página " + getPagAtual() + ".");
    }

    @Override
    public void abrir () {
        if (this.aberto) {
            System.out.println("O livro " + getTitulo() + " já está aberto.");
        } else {
            this.aberto = true;
            System.out.println("O livro " + getTitulo() + " foi aberto.");
        }
    }

    @Override
    public void fechar () {
        if (this.aberto) {
            this.aberto = false;
            System.out.println("O livro " + getTitulo() + " foi fechado.");
        } else {
            System.out.println("O livro " + getTitulo() + " já está fechado.");
        }
    }

    @Override
    public void folhear(int p) {
        if (p<=totalPag) {
            this.pagAtual = p;
            System.out.println("Folheando o livro " + getTitulo() + " até a página " + p + ".");
        } else {
            System.out.println("Não é possível folhear, o número da página é superior ao total de páginas do livro!");
        }
    }

    @Override
    public void passarPag () {
        if (pagAtual < totalPag) {
            setPagAtual(getPagAtual() + 1);
            System.out.println("Você passou uma página do livro " + getTitulo() + ".");
        } else {
            System.out.println("Não é possível passar páginas, você já está na última página do livro.");
        }
    }

    @Override
    public void voltarPag () {
        if (this.aberto) {
            setPagAtual(getPagAtual() - 1);
            System.out.println("Você voltou uma página do livro " + getTitulo() + ".");
        } else {
            System.out.println("Não é possível voltar páginas, o livro " + getTitulo() + " está fechado.");
        }
    }
}

