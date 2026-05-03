package com.imagoPlay.ProjetoImagoPlay.modules.video.enums;
import lombok.Getter;

@Getter
public enum VideoGenero {

    NORDESTERN("Nordestern (Faroeste/Cangaço)"),
    COMEDIA_REGIONAL("Comédia Regional"),
    DRAMA_SERTANEJO("Drama Sertanejo"),
    TERROR_FOLCLORICO("Terror Folclórico / Lendas"),
    CULTURA_POPULAR("Cultura Popular (Cordel, Frevo, Maracatu)"),
    FICCAO_SERTANEJA("Ficção Científica Sertaneja (Sci-Fi / Afrofuturismo)"),

    DOCUMENTARIO("Documentário"),
    ANIMACAO("Animação"),
    ROMANCE("Romance"),
    DRAMA_URBANO("Drama Urbano"),
    EXPERIMENTAL("Experimental / Arte"),
    BIOGRAFIA_MEMORIA("Biografia / Memória Histórica"),
    INFANTIL("Infantil / Infanto-Juvenil"),
    REALISMO_MAGICO("Realismo Mágico / Fantasia"),
    COMEDIA_DE_COSTUMES("Comédia de Costumes"),
    ROAD_MOVIE_REGIONAL("Road Movie (Filme de Estrada)"),
    SUSPENSE_MISTERIO("Suspense / Mistério");

    private final String descricao;

    VideoGenero(String descricao) {
        this.descricao = descricao;
    }
}