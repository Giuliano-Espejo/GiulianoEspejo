#include <program1.h>
/*
*Enunciado: 
*/
estructura Punto {
	publico:
		Punto();
		procedimiento mostrarPunto();
		real x,y;
};
estructura Triangulo {
	
	publico:
		Punto p1;
		Punto p2;
		Punto p3;
		largo doble perimetro;
		procedimiento mostrarTriangulo();
		Triangulo();
};

//Procedimientos
funcion largo doble calcularLado(Punto p1, Punto p2){
	largo doble resultado, lado1, lado2;
	lado1 = abs(p1.x - p2.x);
	lado2 = abs(p1.y - p2.y);
	resultado = raiz2(cuadrado(lado1) + cuadrado(lado2));
	retorna(resultado);
}
	
procedimiento calcPerimetro(Triangulo porRef triang){
	largo doble perimetro=0;
	perimetro=calcularLado(triang.p1,triang.p2)+calcularLado(triang.p2,triang.p3)+calcularLado(triang.p3,triang.p1);
	triang.perimetro=perimetro;
}
	
procedimiento VectorPuntos(vectorDin(Punto) porRef conjunto){
	real punto1,punto2;
	entero cont=0;
	Punto p;
	iterar
		leer(punto1);
		leer(punto2);
	salirSi(punto1 == 0 && punto2 == 0);
		cont++;
		p.x = punto1;
		p.y = punto2;
		agregaEleVDin(conjunto,p);
		//conjunto[tamanio(conjunto)-1].mostrarPunto();
		//mostrar << salto;
	finIterar
	mostrar <<  "La cantidad de puntos es de: " << cont<< salto;
}
	
procedimiento crearTriangulo(vectorDin(Triangulo) porRef triang,vectorDin(Punto) p){
	Triangulo t;
	entero i,j,k;
	variarMas1(i,0,tamanio(p)-3);
		variarMas1(j,i+1,tamanio(p)-2);
			variarMas1(k,j+1,tamanio(p)-1);
				t.p1=p[i];
				t.p2=p[j];
				t.p3=p[k];
				calcPerimetro(t);
				agregaEleVDin(triang,t);
				//t.mostrarTriangulo();
			finVariar
		finVariar
	finVariar
	mostrar << "La cantidad de triangulos creados es de: "<<tamanio(triang) << salto;
}
	
procedimiento mostrarTriangulos(vectorDin(Triangulo) t){
	paraCada(x,t)
		x.mostrarTriangulo();
	finParaCada
	}
	
	procedimiento calcularSumaPer(vectorDin(Triangulo) tri){
	entero i;
	largo largo sumaPer=0;
	variarMas1(i,0,tamanio(tri)-1)
		sumaPer+=tri[i].perimetro;
	finVariar
	mostrar<<"La sumatoria de los perimetros es de: "<<sumaPer<<salto;
}

funcion logico noEsMismoPunto(Punto p1, Punto p2) {
		
	logico resul= VERDADERO;
	si(p1.x ES p2.x Y p1.y ES p2.y) entonces
		resul = FALSO;
	finSi
	regresa(resul);
}
	
procedimiento calcularOrientacion(vectorDin(Punto) puntos, vectorDin(Triangulo) triangulos,vectorDin(Triangulo) porRef triangulosFinal){
	real ori, a, b, c;
	entero i,j;
	
	variarMas1(i,0,tamanio(triangulos)-1)
	ori = (triangulos[i].p1.x - triangulos[i].p3.x)*(triangulos[i].p2.y - triangulos[i].p3.y)-(triangulos[i].p1.y - triangulos[i].p3.y)*(triangulos[i].p2.x - triangulos[i].p3.x);
	
		variarMas1(j,0,tamanio(puntos)-1)
			si(noEsMismoPunto(triangulos[i].p1,puntos[j])&& noEsMismoPunto(triangulos[i].p2,puntos[j]) && noEsMismoPunto(triangulos[i].p3,puntos[j])) entonces
				a = ((triangulos[i].p1.x - puntos[j].x)*(triangulos[i].p2.y - puntos[j].y)-(triangulos[i].p1.y - puntos[j].y)*(triangulos[i].p2.x - puntos[j].x));
				b = ((triangulos[i].p2.x - puntos[j].x)*(triangulos[i].p3.y - puntos[j].y)-(triangulos[i].p2.y - puntos[j].y)*(triangulos[i].p3.x - puntos[j].x));
				c = ((triangulos[i].p3.x - puntos[j].x)*(triangulos[i].p1.y - puntos[j].y)-(triangulos[i].p3.y - puntos[j].y)*(triangulos[i].p1.x - puntos[j].x));
				si(ori>=0) entonces
					si(a>=0 Y b>=0 Y c>=0) entonces
					agregaEleVDin(triangulosFinal,triangulos[i]);
					break;
				finSi
					sino
					si(a<0 Y b<0 Y c<0) entonces
						agregaEleVDin(triangulosFinal,triangulos[i]);
						break;
					finSi
				finSi
			finSi
					
		finVariar
	
		//limpiar
		//mostrar << " " <<(i *100)/tamanio(triangulos)<< "%" << salto;
	finVariar
	mostrar <<"triangulos: " <<tamanio(triangulos) << salto;
	mostrar <<"triangulos Con puntos: " <<tamanio(triangulosFinal) << salto;
}

principal     
	vectorDin(Punto) puntos;
	vectorDin(Triangulo) triangulos;
	VectorPuntos(puntos);
	vectorDin(Triangulo) triangulosFinal;
	si(tamanio(puntos)>2) entonces
		crearTriangulo(triangulos,puntos);
		calcularSumaPer(triangulos);
		calcularOrientacion(puntos, triangulos, triangulosFinal);
		mostrar << "Triangulos con puntos "<<tamanio(triangulosFinal) << salto;
	sino
		mostrar<<"La cantidad de Puntos debe ser mayor a 2 para mostrar algun resultado ";
	finSi
	
finPrincipal

	//CONSTRUCTORES//
	
Punto::Punto() {
	x = 0;
	y = 0;
}
	
procedimiento Punto::mostrarPunto() {
	mostrar <<"x: "<< x ;
	mostrar <<" y: "<< y ;
}
	

Triangulo::Triangulo(){
	p1=Punto();
	p2=Punto();
	p3=Punto();
	perimetro = 0;
}

procedimiento Triangulo::mostrarTriangulo(){
	mostrar << "Punto 1: {";
	p1.mostrarPunto();
	mostrar << "}" << salto;
	mostrar << "Punto 2: {";
	p2.mostrarPunto();
	mostrar << "}" << salto;
	mostrar << "Punto 3: {";
	p3.mostrarPunto();
	mostrar << "}" << salto;
	mostrar<<"lado 1: ";
	mostrar << calcularLado(p1,p2)<<salto;
	mostrar<<"lado 2: ";
	mostrar << calcularLado(p2,p3)<<salto;
	mostrar<<"lado 3: ";
	mostrar << calcularLado(p3,p1)<<salto;
	mostrar << "Perimetro: "<< perimetro << salto;
}

