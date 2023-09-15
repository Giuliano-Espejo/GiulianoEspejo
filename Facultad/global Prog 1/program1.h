// Versi√≥n 2022
#define WINDOWS                                       // Descomentar en Windows
#ifndef PROGRAM1_H                                      // Si se carga por vez 1ÔøΩ
#define PROGRAM1_H
// Inclusiones (¬øcasi todo?)
#include <ostream>
#include <iostream>
#include <Windows.h>
//#include <iterator>
#include <iostream>
#include <iomanip>
#include <sstream>
//#include <functional>
//#include <format>
#include <iomanip>
#include <fstream>
#include <cstdlib>
#include <cmath>
#include <chrono>
#include <ctime>
#include <cstring>
#include <limits>
#include <string>
#include <vector>
#include <array>
#include <queue>
#include <algorithm>
#include <assert.h>
#include <stdio.h>
#include <thread>
#include <pthread.h>
#include <initializer_list>
#include <clocale>
#include <cwchar>

#include <stdio.h>
#include <locale.h>
#include <time.h>
#include <wchar.h>

#include <locale.h>//LibrerÌa acentos

using namespace std;

// SÔøΩlo para Linux:
#ifndef WINDOWS                                             // Si se ejecuta en Linux
#include <unistd.h>
inline unsigned long long memoria() {
    long pag = sysconf(_SC_PHYS_PAGES);
    long tamPag = sysconf(_SC_PAGE_SIZE);
    return pag * tamPag;
}
#ifdef SOCKETS                                              // Si se usan sockets
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#endif
#ifndef TECLAS
#include <termios.h>                                        // (sÔøΩlo para Linux)
#include <unistd.h>
inline int leeTec(bool conEco = true) {
    struct termios oldattr, newattr;
    char ch;
    tcgetattr( STDIN_FILENO, &oldattr );
    newattr = oldattr;
//    newattr.c_lflag &= ~( ICANON );
    newattr.c_lflag &= ~(conEco ? ICANON : ICANON | ECHO);
    tcsetattr( STDIN_FILENO, TCSANOW, &newattr );
//    ch = (((int)(ch=getchar()) == (-61))?leeTecla(conEco):ch);
    if((ch = getchar()) != EOF) tcsetattr( STDIN_FILENO, TCSANOW, &oldattr );
    return ch;
}
#define TECLAS
//#define esFinDeTeclazos(x,y,r) (((x == y)?r++:r=0) > 1000)
//#define esFinDeTeclazos(x)     (x == '\377')
#define pausa                  {char c;mostrar << "En pausa. Una tecla para continuar...";leeTecSinEco(c);}
#define leeTecSinEco(x)        x=leeTec(false)
#define leeTecConEco(x)        ((x=leeTec()) == (-61)?(x=leeTec(true)):x);
#define leeTecla(x)            x=leeTec(true)
#define limpiar                std::cout << "\033[2J\033[1;1H";/*cout << string(22, '\n')*/;
#endif
// SÔøΩlo para Windows
#else
#include <conio.h>
#include <Windows.h>
#include <locale.h>
#define pausa                  {mostrar << "En pausa...";system("pause");}
#define leeTecla(x)            x=getche()
#define leeTecSinEco(x)        x=getch()
#define leeTecConEco(x)        x=getche()
#define limpiar                system("cls");
#endif

/*
   Tipos de datos
*/
#define largo                   long
#define corto                   short
#define entero                  int
#define real                    float
#define doble                   double
#define caracter                char
#define logico                  bool
#define cadena                  std::string
#define clicks                  clock_t
#define Clicks                  clicks
#define tiempoEnCPP             std::chrono::high_resolution_clock
#define TiempoEnCPP             tiempoEnCPP
#define tiempoEnC               time_t
#define TiempoEnC               tiempoEnC
#define sinSigno                unsigned
#define bits(x,cantBits)        unsigned long long x : cantBits
//#define byte                    /*sinSigno*/ caracter
//#define cadena               char *
//typedef char cadena[256];
//typedef char cadena20[20];
//typedef unsigned char byte;
#define FALSO                   false
#define PI                      3.1415927
#define VERDADERO               true
#define enumerado               enum

// ProgramaciÔøΩn genÔøΩrica (metaprogramaciÔøΩn)
#define plantilla2(tipo1,tipo2) template <typename tipo1,typename tipo2>
#define plantilla(tipo)         template <typename tipo>
#define implementa              template

// Estructuras
#define estructura              struct
#define Estructura		        estructura
#define campo

// Objetos
#define clase                           class
#define publico                         public
#define derivadaDe                      :
#define privado                         private
#define amigo                           friend
#define estatico                        static
#define protegido                       protected
#define noCambia                        const
#define nuevo                           new
#define borrar                          delete
#define esto                            this
#define CodConstructorAsumido(unaClase) unaClase::ConstructorAsumido(unaClase)
#define ConstructorAsumido(unaClase)    unaClase()
#define Destructor(unaClase)            ~unaClase()

/*
   Procedimientos
*/
#define mostrar                 std::cout
//#define mostrar1(x)             mostrar << x << salto
//#define mostrar2(x,y...)         mostrar << x << "  " << y << salto
#define mostrarErr              std::cerr
#define fijAncho(x)             std::cout.width(x)
#define conAncho(x)             std::setw(x)
#define usaDecim(x)             std::cout.precision(x)
#define mostrarConDecim(x)      usaDecim(x)
#define leer(x)                 std::cin >> x
#define leerM(x,mens)           mostrar << mens;leer(x)
#define operador                operator

/*
   Traducciones genÔøΩricas
*/
#define Principal              principal
#define principal              int main(int argc, char *argv[]) {setlocale(LC_ALL,"Spanish - ARGENTINA (AR) (es_AR)");setlocale(LC_ALL, "spanish"); SetConsoleCP(1252); SetConsoleOutputCP(1252); // Cambiar STDOUT - Para m·quinas Windows
#define QtPrincipal            int main(int argc, char *argv[]) {QCoreApplication a(argc, argv);
#define finQtPrincipal         return a.exec(); }
#define finPrincipal           return EXIT_SUCCESS;}
#define terminarPrograma       exit(EXIT_SUCCESS)
#define programa               void main() { /##/                               // Borland
#define finPrograma            }
#define procedimiento          Procedimiento
#define Procedimiento          void
#define finProcedimiento       }
#define Funcion
#define funcion
#define finFuncion             }
#define regresa(x)             retorna(x)
#define retorna(x)             return(x)
#define noCompartido           static
#define global                 extern
#define Bloque                 {
#define finBloque              }
// Decisiones
#define si(x)                  if(x)
#define entonces               {
#define sino                   } else {
#define finSi                  }
#define sinoSi(x)              } else if(x)
#define segun(x)               segunCaso(x)
#define segunCaso(x)           switch (x) {
#define finSegun               }
#define sale                   break
#define caso                   case
#define otroCaso               break; case
#define casoAsumido            break; default

// Bucles
#define iterar                 do {
#define salirSi(x)             if(x) break
#define finIterar              } while (VERDADERO);
#define mientras(x)            while (x) {
#define finMientras            }
#define repetir                do {
#define hasta(x)               } while (NO (x));
#define variar(vc,vi,vf,inc)   si(1+((vf-vi)/(inc))>0) for(vc=vi;((inc>0)?(vc<=vf):(vc>=vf));vc+=inc) {
#define variarMas1(vc,vi,vf)   si(1+((vf-vi))>0) for(vc=vi;vc<=vf;vc++) {
#define variarMenos1(vc,vi,vf) si(1+((-vf+vi))>0)for(vc=vi;vc>=vf;vc--) {
#define finVariar              }
#define paraCada(x,conj)       for(auto & x : conj) {
#define paraCadaValor(x,conj)  for(auto x : conj) {
#define finParaCada            }
#define finPara                finParaCada

// Memoria estÔøΩtica
#define arreglo(tipo,tam)                   array<tipo,tam>
#define arreglo2D(tipo,tam1,tam2)           array<array<tipo,tam2>,tam1>
#define arreglo3D(tipo,tam1,tam2,tam3)      array<array<array<tipo,tam3>,tam2>,tam1>

// Memoria dinÔøΩmica
#define matrizDin2DFC(tipo,cF,cC,v)         matrizDin2D(tipo) v (cF,vector<tipo>(cC))
#define de2D(tipo,cF,cC)                    (cF,vector<tipo>(cC))
#define de3D(tipo,cF,cC,cP)                 (cF,vector<vector<tipo>>(cC,vector<tipo>(cP)))
#define vectorDin(tipo)                     vector<tipo>
#define vectorDinT(tipo,tam,v)              vector<tipo> v(tam)
//#define vectorDin(tipo,tam,inic)            vector<tipo>(tam,inic)
#define matrizDin2D(tipo)                   vector<vector<tipo>>
#define matrizDin2DFC(tipo,cF,cC,v)         vector<vector<tipo>> v de2D(tipo,cF,cC)
#define matrizDin3DFCP(tipo,cF,cC,cP,v)     matrizDin3D(tipo) v de3D(tipo,cF,cC,cP)
#define matrizDin3D(tipo)                   vector<vector<vector<tipo>>>
#define insertaEleVDin(vec,valor)           {auto it = vec.begin(); vec.insert(it,(valor));}
#define intercalaEleVDin(vec,valor,pos)     {if(vec.size() > 0) vec.emplace(vec.begin()+(pos),(valor)); else agregaEleVDin(vec,valor);}
#define agregaEleVDin(vec,valor)            {auto it = vec.end(); vec.insert(it,(valor));}
#define borra1EleVDin(vec,pos)              if(tamanio(vec) > pos Y pos >= 0) vec.erase(vec.begin()+(pos));
#define borraPrimero(vec)                   borra1EleVDin(vec,0)
#define borraUltimo(vec)                    borra1EleVDin(vec,tamanio(vec)-1)
#define limpiaVDin(vec)                     vec.clear()
#define borraVDin(vec)                      vec.~vector()
#define tamanio(vec)                        vec.size()
#define tamanioDe(algo)                     sizeof(algo)
#define ajusTamanio(vec,t)                  vec.resize(t)
#define listaDe(tipo)                       vectorDin(tipo)
#define insertaLista(lis,valor)             {auto it = lis.begin(); lis.insert(it,(valor));}
#define intercalaEnLista(lis,valor,pos)     lis.emplace(lis.begin()+(pos),(valor))
//#define agregaALista(lis,valor)             {auto it = lis.end(); lis.insert(it,(valor));}
#define agregaAVecDin(v1,v2)                paraCada(e2,v2) agregaEleVDin(v1,e2);finPara    
#define borraEleLista(lista,ind)            borra1EleVDin(lista,ind)
#define primeroDelVec(vec)                  vec[0]
#define ultimoDelVec(vec)                   vec[tamanio(vec)-1]
#define clasifica(vec)                      std::sort(vec.begin(),vec.end())
#define clasificaCon(vec,funLog)            std::sort(vec.begin(),vec.end(),funLog)
#define busquedaBinario(vecOrd,valBuscado)  std::binary_search(vecOrd.begin(),vecOrd.end(),valBuscado)
// Equivalencias
#define intercambiar(x,y)      swap(x,y)
#define salto                  std::endl
#define sobreEscribe           "\r"
#define saltoPagina            "\f"
#define tabulado               (char) 9
#define ES                     ==
#define NO                     !
#define NOES                   !=
#define bitO                   |
#define O                      ||
#define bitY                   &
#define Y                      &&
#define EQV(a,b)               (((a) Y (b)) O (NO (a) Y NO (b)))
#define NEQV(a,b)              (NO EQV(a,b))
#define bitOEX(x,y)            (x ^ y)
#define porVal
#define porRefStd(x)           std::ref(x)
#define porRef                 &
#define deRef                  *
#define apuntadoPor            *
#define constante              const
// constante cadena LETRAS = "ABCDEFGHIJKLMN—OPQRSTUVWXYZabcdefghijklmnÒopqrstuvwxyz¡…Õ”⁄·ÈÌÛ˙‹¸";

inline cadena aCadena(caracter car) {
	

cadena resul = {car};
regresa(resul);
}

#define esAlgo(car,cad)        (posCarEnCad(car,cad) < -1)
//inline logico esAlgo(caracter car,cadena cad) {
//logico resul = ((largo sinSigno) cad.find(aCadena(car)) < std::string::npos);
//regresa(resul);
//}
//
inline entero posCarEnCad(caracter car,cadena cad) {
	

regresa(cad.find(aCadena(car)));
}

#define esLetra(x)             esAlgo(x,"ABCDEFGHIJKLMN—OPQRSTUVWXYZabcdefghijklmnÒopqrstuvwxyz¡…Õ”⁄·ÈÌÛ˙‹¸")
//inline logico esLetra(caracter car) {
//regresa(esAlgo(car,"ABCDEFGHIJKLMN√ëOPQRSTUVWXYZabcdefghijklm√±opqrstuvwxyz√Å√â√ç√ì√ö√°√©√≠√≥√∫√ú√º"));
//}

//#define esVocalAcentuada(x)    (logico)(strchr("ÔøΩÔøΩÔøΩÔøΩÔøΩÔøΩÔøΩÔøΩÔøΩÔøΩ",x))
//inline logico esVocalAcentuada(caracter car) {
//regresa(esAlgo(car,"√°√©√≠√≥√∫√Å√â√ç√ì√ö"));
//}

inline cadena cambiaCad(cadena porRef cad,cadena origen,cadena destino) {
cadena resul = "";
sinSigno pos,donde;
variarMas1(pos,0,tamanio(cad))
    variarMas1(donde,0,tamanio(origen)-1)
        si(cad[pos] ES origen[donde]) sale;
        finVariar
    resul += (donde < tamanio(origen)) ? destino[donde] : cad[pos];
//    mostrar << resul << salto;
    finVariar
regresa(resul);
}

// Pseudo funciones
#define longitud(x)            (x.length())
#define deCadACar(cad)         (cad[0])
//#define cambiaCad(cad,car1,car2)    {for(auto & car:cad) car=fSi(car ES car1,car2,car);}
#define redondeo(x)            ((entero)((x)+fSi(x>0,0.5,(-0.5))))
#define esAnioBisiesto(a)      (esMult(a,4) Y NO esMult(a,100) O esMult(a,400))
#define equiv(x,y)             (((x) Y (y)) O ((NO (x)) Y (NO (y))))
#define noEquiv(x,y)           (NO equiv(x,y))
#define signo(x)               fSi(x>0,1,fSi(x<0,(-1),0))
#define raiz2(x)               sqrt(x)
#define fSi(x,y,z)             (x?y:z)
#define XalaY(x,y)             pow(x,y)
#define cuadrado(x)            ((x)*(x))
#define SIoNO(x)               ((x)?" Si ": " No ")
#define maximo(a,b)            (a>b?a:b)
#define max3(x,y,z)            max(x,max(y,z))
#define min3(x,y,z)            min(x,min(y,z))
#define minimo(a,b)            (a<b?a:b)
#define estaEntre(v,mn,mx)     ((mn <= v) Y (v <= mx))
#define entreMinMax(x,mn,mx)  (fSi(((x) > (mx)),(mx),fSi(((x) < (mn)),(mn),(x))))
#define esMult(a,b)            ((a % b) ES 0)
#define esImpar(x)             ((x) % 2)
#define esPar(x)               (NO (esImpar(x)))
#define esDigito(x)            ((x >= '0') Y (x <= '9'))
#define esSigno(x)             (NO (esLetra(x) O esDigito(x)))
#define esVocal(x)             esAlgo(x,"AEIOUaeiou¡…Õ”⁄·ÈÌÛ˙")
#define esVocalAcentuada(x)    esAlgo(x,"¡…Õ”⁄·ÈÌÛ˙")
#define esUconDieresis(x)      esAlgo(x,"‹¸")
#define esVocalAbierta(x)      esAlgo(x,"AEOaeo¡…”·ÈÛ"))
#define esVocalCerrada(x)      esAlgo(x,"IUiuÕ⁄Ì˙"))
#define esDiptongo(x,y)        (esVocal(x) Y esVocal(y) Y NEQV(esVocalAbierta(x),esVocalAbierta(y)))
#define esTriptongo(x,y,z)     (esVocalCerrada(x) Y esVocalAbierta(y) Y esVocalCerrada(z))
#define esHiato(x,y)           (esVocalAbierta(x) Y esVocalAbierta(y))
#define esSigno(x)             (NO (esLetra(x) O esDigito(x)))
#define esDiptongo(x,y)        (esVocal(x) Y esVocal(y) Y NEQV(esVocalAbierta(x),esVocalAbierta(y)))
#define esTriptongo(x,y,z)     (logico)(esVocalCerrada(x) Y esVocalAbierta(y) Y esVocalCerrada(z))
#define esHiato(x,y)           (esVocalAbierta(x) Y esVocalAbierta(y))
//#define derecha(cadX,n)        (cadX.substr((cadX.size()-n),(n)))
#define derecha(cadX,n)        (cadX.substr(cadX.size()-n,n))
#define izquierda(cadX,n)      (cadX.substr(0,n))
#define subCad(cadX,po,n)      (cadX.substr(po,n))
#define carCad(cadX,po)        (cadX.substr(po,1))
#define sinPrimerCar(cad)      (cad.substr(1))
#define sinUltimoCar(cad)      (izquierda(cad,longitud(cad)-1))
#define esSubcadEnCad(scad,cad)(posScadEnCad(scad,cad) < std::string::npos)
#define posScadEnCad(scad,cad) (cad.find(scad))
#define sinCarPos(x,cad)       (cad.substr(0,x-1)+cad.substr(x))
#define reemplaza(cad,ini,cant,subcad) cad.replace(ini,cant,subcad)
#define cambiaCar(cad,po,subc) cad.replace(po,1,subc)
#define esConso(x)             (esLetra(x) Y NO esVocal(x))
#define plural(x)              fSi(x NOES 1,"s","")
#define esComPal(x,y)          (esSigno(x) Y NO esSigno(y))
#define esFinPal(x,y)          (NO esSigno(x) Y esSigno(y))
#define aCaracter(x)           "0123456789"[x]
#define arcoTangente(y,x)      atan2(y,x)
#define senoGrados(x)          sin(radianes(x))
#define coseno(x)              cos(x)
#define cosenoGrados(x)        cos(radianes(x))
#define tangenteGrados(x)      tan(radianes(x))
#define gradosARadianes        (PI/180.0)
#define radianesAGrados        (1./gradosARadianes)
#define grados(x)              (radianesAGrados*(x))
#define radianes(x)            (gradosARadianes*(x))
//#define grados360(x)           grados(fSi(x < 0,(x+2*PI),fSi(x >= 2*PI,(x-2*PI),(x))))
#define grados360(x)           fSi(grados(x) < 0,grados(x)+360.,fSi(grados(x)>= 360,grados(x)-360.,grados(x)))
#define distancia2(x1,y1,x2,y2) raiz2(cuadrado((x2)-(x1))+ cuadrado((y2)-(y1)))
#define distancia3(x1,y1,x2,y2,z1,z2) raiz2(cuadrado(x2-x1)+ cuadrado(y2-y1) + cuadrado(z2-z1))
#define angulo(x1,y1,x2,y2)    atan2((y2-y1),(x2-x1))
#define angEnGr(x1,y1,x2,y2)   grados(arcoTangente((y2-y1),(x2-x1)))
#define angEnG360(x1,y1,x2,y2) grados360(arcoTangente((y2-y1),(x2-x1)))
#define valorMaximo(tipo)      std::numeric_limits<tipo>::max()
#define valorMinimo(tipo)      std::numeric_limits<tipo>::min()
#define minimoApreciable(tipo) std::numeric_limits<tipo>::epsilon()
#define aHexa(nro)             decABase(nro,16)
#define aOctal(nro)            decABase(nro,8)
#define aBinario(nro)          decABase(nro,2)
#define idLetraIni(nro)        decABase(nro,26,10)



inline cadena decABase(entero dec,entero base, entero ign = 0) {
cadena resul;
si(dec >= base) entonces
    resul = decABase(dec / base,base,ign) + decABase(dec % base,base,ign);
    sinoSi(dec >= 0) entonces
    resul = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"[dec+ign];
    sino
    resul = "-" + decABase(-dec,base,ign);
    finSi
regresa(resul);
}

//Fechas y tiempo

#define ahoraC()                    clock()
//#define ahoraC()                     time(nullptr)
//#define poneCadAhora(c)        {TiempoEnC seg = ahora(); struct tm * infoTiempo = localtime(& seg); c = asctime(infoTiempo);}
inline funcion struct tm * estrTiempoActual() {
struct tm * resul;
TiempoEnC seg = ahoraC();
resul = localtime(& seg);
regresa(resul);
}
inline funcion cadena cadDiaSem(entero diaSem) {
assert(0 <= diaSem Y diaSem < 7);
cadena resul [] = {"Domingo","Lunes","Martes","MiÈrcoles","Jueves","Viernes","S·bado"};
regresa(resul[diaSem]);
}
inline funcion cadena cadMes(entero mes) {
assert(0 <= mes Y mes < 12);
cadena resul [] = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
regresa(resul[mes]);
}
// Hoy
#define cadHoyIngles()              (asctime(estrTiempoActual()))
#define numeroDiaHoy()              (estrTiempoActual()->tm_mday)
#define cadDiaHoy()                 (aCadena(numeroDiaHoy()))
#define numeroMesHoy()              (1+estrTiempoActual()->tm_mon)
#define cadMesHoy()                 cadMes(numeroMesHoy())
#define numeroAnioHoy()             (1900+estrTiempoActual()->tm_year)
#define cadAnioHoy()                (aCadena(numeroAnioHoy()))
#define numeroHoraHoy()             (estrTiempoActual()->tm_hour)
#define cadHoraHoy()                (aCadena(numeroHoraHoy()))
#define numeroMinHoy()              (estrTiempoActual()->tm_min)
#define cadMinHoy()                 (aCadena(numeroMinHoy()))
#define numeroSegHoy()              (estrTiempoActual()->tm_sec)
#define cadFechaHoy()               (aCadena(numeroDiaHoy(),"00")+"/"+aCadena(numeroMesHoy(),"00")+"/"+aCadena(numeroAnioHoy(),"00"))
#define cadDiaSemHoy()              (cadDiaSem(estrTiempoActual()->tm_wday))
#define cadCortaDiaSemHoy()         (cadDiaSem(estrTiempoActual()->tm_wday).substr(0,3))
#define cadHorMinSegHoy()           (aCadena(numeroHoraHoy(),"00")+":"+aCadena(numeroMinHoy(),"00")+":"+aCadena(numeroSegHoy(),"00"))
#define cadLargaTiempoHoy()         (cadDiaSemHoy()+" "+cadHorMinSegHoy())
#define cadFechaAhora()             (cadDiaSemHoy()+", "+cadDiaHoy())
#define cadLargaAhora()             (cadFechaHoy()+" "+cadHorMinSegHoy())
#define ahoraCrono(tIni)            tIni = ahora()
#define ahora()                     std::chrono::high_resolution_clock::now()
#define lapsoMicrosegs(ini,fin)     std::chrono::duration_cast<std::chrono::microseconds>(fin-ini).count()
#define lapsoMilisegs(ini,fin)      std::chrono::duration_cast<std::chrono::milliseconds>(fin-ini).count()
#define lapsoSegs(ini,fin)          (lapsoMilisegs(ini,fin)/1000)
#define lapsoMins(ini,fin)          (lapsoSegs(ini,fin)/60)
#define lapsoHors(ini,fin)          (lapsoMins(ini,fin)/60)

//// ConversiÔøΩn a cadenas
//inline funcion cadena aCadena(entero nro) {
//cadena resul;
//si(nro >= 10) entonces
//    resul = aCadena(nro/10) + aCadena(nro % 10);
//    sinoSi(nro < 0) entonces
//    resul = "-" + aCadena(-nro);
//    sino
//    segun(nro)
//        caso 0      : resul = "0";
//        otroCaso 1  : resul = "1";
//        otroCaso 2  : resul = "2";
//        otroCaso 3  : resul = "3";
//        otroCaso 4  : resul = "4";
//        otroCaso 5  : resul = "5";
//        otroCaso 6  : resul = "6";
//        otroCaso 7  : resul = "7";
//        otroCaso 8  : resul = "8";
//        otroCaso 9  : resul = "9";
//        casoAsumido : resul = "*";
//        finSegun
//    finSi
//regresa (resul);
//}
//inline funcion cadena aCadena(real nro, entero dig) {
//cadena resul = aCadena((entero)nro) + "." + aCadena((entero)((nro-(entero)nro)*XalaY(10,dig)));
//regresa(resul);
//}
//inline funcion cadena aCadena(entero nro, cadena relleno) {
//cadena resul = aCadena(nro);
//entero difLongi = relleno.length() - resul.length();
//si( difLongi > 0) entonces
//    resul = relleno.substr(0,difLongi) + resul;
//    finSi
//regresa(resul);
//}

//inline funcion cadena cadLapsoHMSMM(auto ini,auto fin) {
//sinSigno largo largo hor = lapsoHors(ini,fin)
//                     ,mi = lapsoMins(ini,fin)-(hor*60)
//                    ,seg = lapsoSegs(ini,fin)-mi*60
//                    ,msg = lapsoMilisegs(ini,fin)-seg*1000
//                    ,mic = lapsoMicrosegs(ini,fin)-msg*1000;
//cadena resul = aCadena(hor,"00")+"h"
//              +aCadena(mi,"00")+"m"
//              +aCadena(seg,"00")+"s,"
//              +aCadena(msg,"000")
//              +aCadena(mic % 1000,"000");
//regresa(resul);
//}
//
//inline funcion largo largo aEntero(noCambia cadena porRef cad) {
//largo largo resul
//      ,longi = cad.length();
//si(longi > 0) entonces
//    si(cad.substr(0,1) ES "-") entonces
//        resul = -aEntero(cad.substr(1));
//        sinoSi(longi > 1) entonces
//        resul = 10 * aEntero(cad.substr(0,longi-1)) + aEntero(cad.substr(longi-1,1));
//        sino
//        cadena cadDigitos = "0123456789";
//        resul = cadDigitos.find(cad);
//        finSi
//    sino
//    resul = 0;
//    finSi
//regresa(resul);
//}
//
//inline funcion cadena sinAcentos(noCambia cadena porRef cad) {
//cadena resul = cad
//      ,vocAcent = "√°√©√≠√≥√∫√Å√â√ç√ì√ö"
//      ,vocales  = "aeiouAEIOU";
//sinSigno pos;
//paraCada(car,resul)
//    pos = 0;
//    paraCada(a,vocAcent)
//        si(a == car) break;
//        pos++;
//        finPara
//    si(pos < longitud(vocales)) car = vocales[pos];
//    finPara
//regresa(resul);
//}
//
//inline funcion logico tieneDieresis(noCambia cadena porRef cad) {
//logico resul = FALSO;
//paraCada(c,cad)
//    resul = resul O esUconDieresis(c);
//    finPara
//regresa(resul);
//}
//
//#define noTieneDieresis(c)  (NO tieneDieresis(c))
//
//inline logico tieneAcentuada(cadena cad) {
//sinSigno resul = FALSO;
//paraCada(c,cad)
//    si(esVocalAcentuada(c)) resul = VERDADERO;
//    finPara
//regresa(resul);
//}
//
//inline funcion cadena sinDieresis(noCambia cadena porRef cad) {
//cadena resul = cad
//      ,uConDieresis = "ÔøΩÔøΩ"
//      ,uSinDieresis = "uU";
//sinSigno pos;
//paraCada(car,resul)
//    pos = 0;
//    paraCada(a,uConDieresis)
//        si(a == car) break;
//        pos++;
//        finPara
//    si(pos < longitud(uSinDieresis)) car = uSinDieresis[pos];
//    finPara
//regresa(resul);
//}
//
//inline funcion cadena mayusculas(noCambia cadena porRef cad) {
//cadena resul = cad
//      ,mayus = "ABCDEFGHIJKLMN√ëOPQRSTUVWXYZ"
//      ,minus = "abcdefghijklmn√±opqrstuvwxyz";
//resul = cambiaCad(resul,minus,mayus);
//regresa(resul);
//}

//inline funcion caracter mayuscula(cadena cad) {
//cadena resul = mayusculas(cad);
//regresa(resul[0]);
//}
//
//inline funcion cadena minusculas(noCambia cadena porRef cad) {
//cadena resul = cad
//      ,origen = "ABCDEFGHIJKLMNÔøΩOPQRSTUVWXYZ√Å√â√ç√ì√ö√ú"
//      ,destino = "abcdefghijklmnÔøΩopqrstuvwxyz√°√©√≠√≥√∫√º";
//resul = cambiaCad(resul,origen,destino);
//regresa(resul);
//}
//
//inline funcion caracter minuscula(cadena cad) {
//cadena resul = minusculas(cad);
//regresa(resul[0]);
//}
//
//inline funcion cadena normaliza(noCambia cadena porRef cad) {
//cadena resul = cad;
//resul = sinAcentos(resul);
//resul = sinDieresis(resul);
//resul = minusculas(resul);
//regresa(resul);
//}
//////
//union U {
//    cadena resul;
//    cadena v[256];
//    U() {};
//    U(cadena cad) {resul = cad;};
//    U(cadena cad1,cadena cad2) {
//        sinSigno t1 = tamanio(cad1)
//                ,t2 = tamanio(cad2);
//        sinSigno i,i2;
//        variarMas1(i,0,t1-1)
//            v[i] = cad1[i];
//            finVariar
//        i2 = 0;
//        variarMas1(i,t1,t1+t2-1)
//            v[i] = cad2[i2++];
//            finVariar
//        v[t1+t2] = '\0';
//        };
//    ~U() {};
//    };
//
//inline cadena concatena( cadena cad1, cadena cad2) {
//cadena resul = "";
//resul.append(cad1).append(cad2);
//regresa(resul);
//}
//
//inline funcion cadena nombrePropio(noCambia cadena porRef cad) {
//cadena resul = cad;
//resul = minusculas(resul);
//resul[0] = mayusculas(izquierda(resul,1))[0];
//regresa(resul);
//}

// Posiblemente innecesarias en G++
#define cadIguales(x,y)             (strcmp(x,y) ES 0)
#define agregaYaX(x,y)              x.append(y)
#define borraCad(x)                 while(strlen(x)) x[longitud(x)-1]='\0'
#define asigna(carX,cadY)           borraCad(cadY);cadY[0]=carX
#define agrega(cadX,carY)           cadX[longitud(cadX)] = carY
#define inserta(carX,cadY)          {int largoCadY = longitud(cadY);for(int _p=largoCadY;_p>0;p--)cadY[_p] = cadY[_p-1];cadY[0] = carX;}
//#define rellena(carX,n,cadY)        {cadY="";for(int _p=0;_p<n;_p++)cadY += carX;}
#define rellena(cad,n,car)          cad.append(n,car)
#define duplicaCadena(o,d)          strcpy(d,o)
#define carALargo(c)                strtol(c,NULL,10)

// Al azar
#define iniciAlAzar                 srand(time(0))
#define alAzar                      rand()
#define alAzarHasta(x)              redondeo(alAzarReal*(x))
#define alAzarEntre(x,y)            ((x)+alAzarHasta((y)-(x)))
#define alAzarReal                  (rand()/(real)RAND_MAX)
#define alAzarRealHasta(x)          (alAzarReal*(x))
#define alAzarRealEntre(x,y)        (x+(y-x)*alAzarReal)
#define decimales(x,deci)           (entero)((x)*XalaY(10,deci))/XalaY(10,deci)
//#define alAzarDecHasta(x,y)    alAzarHasta(x * (entero)XalaY(10,x))/XalaY(10,x)

//Archivos
#define archivo                             fstream
#define flujoEntrada(ent,arch,modo)         std::ifstream ent(arch,modo)
//#define flujoEntrada(ent,arch)              std::ifstream ent(arch,std::ifstream::in)
#define flujoSalida(sal,arch,modo)          std::ofstream sal(arch,modo)
//#define flujoSalida(sal,arch)               std::ofstream sal(arch,std::ofstream::out)
#define abrir(arch,nombre, modo)            arch.open(nombre,modo)
//#define abrir(arch,nombre)                  arch.open(nombre)
#define cerrar(arch)                        arch.close()
#define estaAbierto(arch)                   arch.is_open()
#define esFinArch(arch)                     feof(arch)
#define esFinDArch(arch)                    arch.eof()
#define todoBien(arch)                      arch.good()
#define errorEn(arch)                       arch.fail()
#define estaMal(arch)                       arch.bad()
#define leeRenglon(cad)                     getline(std::cin,cad)
#define leeRengArch(arch,cad)               getline(arch,cad)
#define puntLectura(arch)                   arch.tellg()
#define puntEscritura(arch)                 arch.tellp()
#define posAbsLectura(arch)                 arch.seekg()
#define posAbsEscritura(arch)               arch.seekp()
#define posRelLectura(arch,cuanto,desde)    arch.seekg(cuanto,desde)
#define posRelEscritura(arch,cuanto,desde)  arch.seekp(cuanto,desde)
#define DESDEINICIO                         ios::beg
#define DESDEFIN                            ios::end
#define DESDEACA                            ios::cur
#define ALEER                               std::ios_base::in
#define AESCRIBIR                           std::ios_base::out
#define ALFINAL                             std::ios_base::ate
#define AGREGAR                             std::ios_base::app
#define ATRUNCAR                            std::ios_base::trunc
#define BINARIO                             std::ios_base::binary

// GrÔøΩficos OpenGL
#define grafico                             ;glutInit (&argc, argv);
#define Gr_iniModo(modo)                    glutInitDisplayMode(modo)
#define Gr_iniTamVent(tHor,tVert)           glutInitWindowSize(tHor,tVert)
#define Gr_iniPosVent(posX,posY)            glutInitWindowPosition(posX,posY)
#define Gr_Vista(posX,posY,tHor,tVert)      glViewport(posX,posY,tHor,tVert)
#define Gr_creaVentana(titulo)              glutCreateWindow(titulo)
#define Gr_mostrar()                        glutMainLoop()
#define Gr_limpiarColor(rojo,verde,azul,op) glClearColor(rojo,verde,azul,op)
#define Gr_limpiar(buff)                    glClear(buff)
#define Gr_RVA(rojo,verde,azul)             glColor3f(rojo,verde,azul)
#define Gr_RVA4(rojo,verde,azul,op)         glColor4f(rojo,verde,azul,op)
#define Gr_colorFondo(rojo,verde,azul,op)   glClearColor(rojo,verde,azul,op)
#define Gr_empieza(algo)                    glBegin(algo)
#define Gr_empiezaPuntos()                  Gr_empieza(GL_POINTS)               // Puntos
#define Gr_tamPunto(tama)                   glPointSize(tama)
#define Gr_empiezaSegmentos()               Gr_empieza(GL_LINES)                // Pares de puntos definiendo segmentos no conectados
#define Gr_empiezaLineas()                  Gr_empieza(GL_LINE_STRIP)           // VÔøΩrtices conectados por lÔøΩneas
#define Gr_empiezaLineasCerradas()          Gr_empieza(GL_LINE_LOOP)            // VÔøΩrtices conectados por lÔøΩneas mÔøΩs la ÔøΩltima con la primera
#define Gr_lineaDePuntos(bitX16)            glLineStipple(1,bitX16)             // PatrÔøΩn de dibujo de la lÔøΩnea
#define Gr_anchoLinea(ancho)                glLineWidth(ancho)                  // Ancho de la linea
#define Gr_HabLineaDePuntos()               Gr_habilita(GL_LINE_STIPPLE)
#define Gr_empiezaTriangulos()              Gr_empieza(GL_TRIANGLES)            // Triplas de vÔøΩrtices definiendo triÔøΩngulos
#define Gr_empiezaTriangulosConectados()    Gr_empieza(GL_TRIANGLE_STRIP)       // TriÔøΩngulos conectados
#define Gr_empiezaVentilador()              Gr_empieza(GL_TRIANGLE_FAN)         // TriÔøΩngulos conectados como aspas de un ventilador
#define Gr_empiezaCuadrilateros()           Gr_empieza(GL_QUADS)                // Cuatriplas definiendo cuadrilÔøΩteros
#define Gr_empiezaCuadrilaterosConectados() Gr_empieza(GL_QUAD_STRIP)           // CuadrilÔøΩteros conectados
#define Gr_empiezaPoligonos()               Gr_empieza(GL_POLYGON)              // PolÔøΩgono
#define Gr_termina                          glEnd
#define Gr_habilita(algo)                   glEnable(algo)
#define Gr_inhabilita(algo)                 glDisable(algo)
#define Gr_estaHabilitado(algo)             glIsEnabled(algo)
#define Gr_vertice(x,y,z)                   glVertex3f(x,y,z)
#define Gr_procesa()                        glFlush()
#define Gr_procMuestra(proc)                glutDisplayFunc(proc)
#define Gr_eventoRedim(proc)                glutReshapeFunc(proc)
#define Gr_eventoTecla(proc)                glutKeyboardFunc(proc)
#define Gr_eventoRaton(proc)                glutMouseFunc(proc)
#define Gr_eventoMueve(proc)                glutMotionFunc(proc)
#define Gr_eventoDescanso(proc)             glutIdleFunc(proc)
#define Gr_modeloDibujo(modelo)             glShadeModel(modelo)
#define Gr_ModoMatriz(m)                    glMatrixMode(m)
#define Gr_ApilaMatriz()                    glPushMatrix()
#define Gr_DesapilaMatriz()                 glPopMatrix()
#define Gr_IntercambiaBuffers()             glutSwapBuffers()

// Concurrencia (compilar con -pthread)
#define Hilo                                std::thread
#define MaxHilos                            Hilo::hardware_concurrency
#define IdHilo                              std::this_thread::get_id
#define DuermeEsteHiloMilliS(milis)         std::this_thread::sleep_for(std::chrono::milliseconds(milis))
#define DuermeEsteHiloMicroS(micrs)         std::this_thread::sleep_for(std::chrono::microseconds(micrs))
#define EsperaHilo(x)                       x.join()
#define EsEsperableHilo(x)                  x.joinable()
#define NoEsperaHilo(x)                     x.detach()
#define MutuamExclusivo                     std::mutex
#define PuntExclusivo(Tipo,p)               unique_ptr<Tipo> p
#define PuntCompartido(Tipo,p)              shared_ptr<Tipo> p
#define BloqueaMutEx(x)                     x.lock()
#define DesbloqueaMutEx(x)                  x.unlock()
#define BloqueoUnicoMutEx(x)                unique_lock<mutex> x
#define BloqueoUnicoDiferidoMutEx(b,m)      unique_lock<mutex> b {m,defer_lock}
//#define BloqueoMultMutEx(b1,b2)             unique_lock<mutex> b1 {m1,defer_lock};unique_lock<mutex> b2 {m2,defer_lock};

// Sockets
#ifdef SOCKETS
#define DireccionSocketEntrada              sockaddr_in
#define DireccionSocket                     sockaddr
#define CreaSocket(dom,tipo,prot)           socket(dom,tipo,prot)
#define Conecta(sock,dir,tDir)              connect(sock,dir,tDir)
#define LeeSocket(sock,dir,tDir)            read(sock,dir,tDir)
#define EnviaMensaje(sock,buf,longBuff,opc) send(sock,buf,longBuff,opc)
#define Enlaza(sock,dir,tDir)               bind(sock,dir,tDir)
#define Escucha(sock,tam)                   listen(sock,tam)
#define Acepta(sock,dir,tDir)               accept(sock,dir,tDir)
#define FijaOpcionesSocket(o1,o2,o3,o4,o5)  setsockopt(o1,o2,o3,o4,o5)
#define IPaBinario(tipoIP,ip,dirServ)       inet_pton(tipoIP,ip,dirServ)
#endif

// Procesamiento de errores
#define PRUEBA          try {
#define FINPRUEBA       }
#define SIERROR(e)      } catch(e) {
#define SIALGUNERROR    } catch(...) {
#define ERROR(e)        throw (e)

// Otras
//#define DEPURACION
//#define GENERAZAR
//#define ORDENADO
#endif
