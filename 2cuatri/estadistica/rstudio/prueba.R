acumuladas<-function(v){
  w<-v[1]
  for (i in 2:length(v))
    w<-c(w, w[i-1]+v[i])
  return(w)
}

datos=c(11,26,43,52,41,46,42,33,32,59,58,51,48,51,60,25,29,47,44,41,48,59,43,57,51,18,92,
        69,60,10,41,56,49,43,63,35,5,21,65,41,59,52,9,73,74,28,35,2,37,68,70,8,1,12,
        21,6,32,15,11,22,29,14,31,62,3,17,39,22,40,81,20,36,59,38,40,31,15,46,65,43,
        44,67,19,30,18,84,47,49,31,60,64,61,51,16,71,82,47,71,80,44)
t<-table(datos)
t
h<-hist(datos,plot=FALSE)
h
tabla<-h[c(1,4,2)]
tabla
names(tabla)<-c("L_i","x_i","n_i")
tabla
tabla[["f_i"]]<-tabla[["n_i"]]/sum(tabla[["n_i"]])
tabla
tabla[["p_i"]]<-tabla[["f_i"]]*100
tabla

tabla[["N_i"]]<-acumuladas(tabla[["n_i"]])
tabla[["F_i"]]<-acumuladas(tabla[["f_i"]])
tabla[["P_i"]]<-acumuladas(tabla[["p_i"]])
tabla

hist(datos,main="Histograma de frecuencias",xlab="Calificaciones de Matemáticas",
     ylab="Frecuencias",col="pink")
    