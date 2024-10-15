# Rubén Oliva Zamora, Ingeniería del Software A

# 2. En cada caso, determinar el tipo de distribución, organizar los datos en 
# una tabla de frecuencias y representar gráficamente la distribución. También 
# se pide, calcular algunas medidas de tendencia central, medidas de dispersión, 
# de simetría y de apuntamiento.

# (b) Resultados obtenidos en las pruebas de durabilidad de 80 lámparas 
# eléctricas con filamento de tungsteno. La vida de cada lámpara se da en 
# horas, aproximando las cifras a la hora más cercana.

#Utilizando los datos del Ejercicio 2 (b) de la relación de problemas, haz una 
# tabla de frecuencias, tanto simple como compuesta, un histograma de 
# frecuencias y calcula medidas de tendencia central, de dispersión, 
# de simetría y de apuntamiento utilizando R. 

datos=c(854, 1284, 1001, 911, 1168, 963, 1279, 1494, 798, 1599, 1357, 1090, 1082,
        1494, 1684, 1281, 590, 960, 1310, 1571, 1355, 1502, 1251, 1666, 778, 1200,
        849, 1454, 919, 1484, 1550, 628, 1325, 1073, 1273, 1710, 1734, 1928, 1416,
        1465, 1608, 1367, 1152, 1393, 1339, 1026, 1299, 1242, 1508, 705, 1199, 1155,
        822, 1448, 1623, 1084, 1220, 1650, 1091, 210, 1058, 1930, 1365, 1291, 683,
        1399, 1198, 518, 1199, 2074, 811, 1137, 1185, 892, 937, 945, 1215, 905,
        1810, 1265)

cat("TABLA SIMPLE\n")
tabla_simple<-table(datos)
print(tabla_simple)

# las frecuencias absolutas son demasiado pequeñas, motivo por el que no
# calculo más parámetros (acumuladas, relativas...). Haré un 
# tratamiento continuo de la variable

h<-hist(datos, plot = FALSE)

tabla_comp <- h[c(1,4,2)]
names(tabla_comp)<-c("L_i","x_i","n_i")
tabla_comp[["f_i"]] <- tabla_comp[["n_i"]]/sum(tabla_comp[["n_i"]])
tabla_comp[["p_i"]]<-tabla_comp[["f_i"]]*100

# CÁLCULO DE ACUMULADAS
acumuladas<-function(v){
  w<-v[1]
  for (i in 2:length(v))
    w<-c(w, w[i-1]+v[i])
  return(w)
}

tabla_comp[["N_i"]]<-acumuladas(tabla_comp[["n_i"]])
tabla_comp[["F_i"]]<-acumuladas(tabla_comp[["f_i"]])
tabla_comp[["P_i"]]<-acumuladas(tabla_comp[["p_i"]])
cat("\n\nTABLA COMPUESTA\n")
print(tabla_comp)

# HISTOGRAMA
hist(datos,main="Histograma de frecuencias",
     xlab="Horas de durabilidad de las lámparas eléctricas",
     ylab="Frecuencias",col="hotpink")

cat("\nMEDIDAS DE TENDENCIA CENTRAL\n")
cat("Media\n")
media<-mean(datos)
print(media)

cat("Mediana\n")
mediana<-median(datos)
print(mediana)

cat("\nCuantiles:\n")
cat("Percentiles\n")
perc <- quantile(datos, (0:100)/100)
print(perc)
cat("\nDeciles\n")
dec <- quantile(datos, (0:10)/10)
print(dec)
cat("\nCuartiles\n")
cuart <- quantile(datos)   # por defecto, escribe los cuartiles
print(cuart)

cat("\nMedia cuadrática\n")
m_cuadratica<-sqrt(sum((datos)^2)/length(datos))
print(m_cuadratica)

cat("\nMEDIDAS DE DISPERSIÓN\n")
cat("Desviación media\n")
desv_media <- sum(abs(datos-media))/length(datos)
print(desv_media)

cat("Cuasi-varianza\n")
cuasi_varianza <- var(datos)
print(cuasi_varianza)

cat("Varianza\n")
varianza <- (length(datos)-1)/length(datos)*cuasi_varianza
print(varianza)

cat("Desviación típica\n")
desv_tipica <- sqrt(varianza)
print(desv_tipica)

cat("\nVariable tipificada\n")
tip<-(datos-media)/desv_tipica
print(tip)

cat("\nCoeficiente de variación de Pearson\n")
cv <- (desv_tipica/abs(media))*100
print(cv)

cat("Momentos - momento central de orden 3 y 4\n")
mu_3 <- sum((datos-media)^3)/length(datos)
mu_4 <- sum((datos-media)^4)/length(datos)
print(mu_3)
print(mu_4)

cat("\n\nPARÁMETROS DE FORMA:\n\n")
cat("SIMETRÍA:\n")
cat("Coeficiente de asimetría de Fisher\n")
g1 <- mu_3/desv_tipica^3
print(g1)

cat("\nAPUNTAMIENTO:\n")
cat("Coeficiente de aplastamiento de Fisher (orden 4)\n")
g2 <- (mu_4/(desv_tipica^4))-3
print(g2)

