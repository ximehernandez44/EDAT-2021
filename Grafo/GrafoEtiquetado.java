
package grafo;

public class GrafoEtiquetado {
//variables


//constructores
public GrafoEtiquetado() {
NodoVert inicio;
}

public boolean insertarVertice(Object vertice) {
    //Dado un elemento de tipo Object se lo agrega a la estructura HOla
}

public boolean eliminarVertice(Object vertice) {
//Dado un elemento de TipoVertice se lo quita de la estructura. Si se encuentra el vértice, también deben eliminarse todos los arcos que lo tengan como origen o destino.
}

public boolean insertarArco(Object origen, Object destino) {
//Dados dos elementos de TipoVertice (origen y destino) agrega el arco en la estructura, sólo si ambos vértices ya existen en el grafo
}

public boolean eliminarArco(Object origen, Object destino) {
    // Dados dos elementos de TipoVertice (origen y destino) se quita de la estructura el arco que une ambos vértices.
}

public boolean existeVertice(Object vertice) {
    //Devuelve verdadero si vertice esta en la estructura, y falso en caso contrario
}

public boolean existeArco(Object origen, Object destino) {
    //Dado dos elementos de TipoVertice (origen y destino), devuelve verdadero si existe un arco que los une y falos en caso contrario.
}

public boolean esVacio() {

}


public String toString() {
    //genera y devuelve una cadena String que muestra los vértices almacenados en el grafo y qué adyacentes tiene cada uno de ellos.
}

}

/*
public boolean existeCamino(Object origen, Object destino) {
    //Dado dos elementos de TipoVertice (origen y destino) devuelve verdadero si existe al menos un camino que permite llegar del vertice origen al vertie destino
}

public Lista caminoMasCorto(Object origen, Object destino) {
    /*Dados dos elementos de TipoVertice (origen y destino), devuelve un camino (lista de vértices)
que indique el camino que pasa por menos vértices que permite llegar del vértice origen al vértice
destino. Si hay más de un camino con igual cantidad de vértices, devuelve cualquiera de ellos. Si
alguno de los vértices no existe o no hay camino posible entre ellos devuelve la lista vacía.*/
}
/*
public Lista caminoMasLargo(Object origen, Object destino) {
    /*Dados dos elementos de TipoVertice (origen y destino), devuelve un camino (lista de vértices)
que indique el camino que pasa por más vértices (sin ciclos) que permite llegar del vértice origen
al vértice destino. Si hay más de un camino con igual cantidad de vértices, devuelve cualquiera de
ellos. Si alguno de los vértices no existe o no hay camino posible entre ellos devuelve la lista vacía.*/
}
/*
public Lista listarEnProfundiad() {
    //devuelve una lista con los vertices del grafo visitados segun el recorrido en profundidad
}

public Lista listarEnAnchura() {
    //devuelve una lista con los vertices del grafo visitados segun el recorrido en anchura
} */

/*
public Grafo clone() {
    //genera y devuelve un grafo que es equivalente al original
} */