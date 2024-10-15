# RUBÉN OLIVA ZAMORA. INGENIERÍA DEL SOFTWARE, A
# DNI: 53925084C

# año, hombres y mujeres no han sido utilizadas
#año <- c(1940, 1950, 1960, 1970, 1980, 1990, 2000, 2005)
codigo <- c(0, 1, 2, 3, 4, 5, 6, 6.5)
#hombres <- c(66.1, 72.2, 88.3, 98.9, 110.1, 121.2, 138.1, 146.0)
#mujeres <- c(65.6, 76.1, 91.0, 104.3, 116.5, 127.5, 143.4, 150.4)
diferencia <- c(0.5, -0.9, -2.7, -5.4, -6.4, -6.3, -5.3, -4.4)

plot(codigo,diferencia)

SSE_residuos <- function(res){
  sum(res^2)
}

# a) Ajuste lineal
datos_ajuste_l <- lm(diferencia ~ codigo)
coefl <- datos_ajuste_l$coefficients

yest_lineal <- coefl[1] + coefl[2]*codigo
residuos_lineal <- datos_ajuste_l$residuals

SSE_lineal <- SSE_residuos(residuos_lineal)
lines(codigo,yest_lineal)

# b) Ajuste cuadrático
datos_ajuste_c <- lm(diferencia ~ codigo+I(codigo^2))
coefc <- datos_ajuste_c$coefficients

yest_cuadratico <- coefc[1] + coefc[2]*codigo + coefc[3]*codigo^2
residuos_cuadratico <- datos_ajuste_c$residuals

SSE_cuadratico <- SSE_residuos(residuos_cuadratico)
lines(codigo,yest_cuadratico)

# c) Ajuste cúbico
datos_ajuste_cub <- lm(diferencia ~ codigo+I(codigo^2)+I(codigo^3))
coefcub <- datos_ajuste_cub$coefficients

yest_cubico <- coefcub[1] + coefcub[2]*codigo + coefcub[3]*codigo^2 + coefcub[4]*codigo^3
residuos_cubico <- datos_ajuste_cub$residuals

SSE_cubico <- SSE_residuos(residuos_cubico)
lines(codigo,yest_cubico)

# d) Con cada modelo: dar el valor ajustado, los residuales y el SSE
# LINEAL
cat("\nMODELO LINEAL\nVALORES AJUSTADOS: ", yest_lineal, "\nRESIDUALES", residuos_lineal, "\nSSE:", SSE_lineal)
# CUADRÁTICO
cat("\n\nMODELO CUADRÁTICO\nVALORES AJUSTADOS: ", yest_cuadratico, "\nRESIDUALES", residuos_cuadratico, "\nSSE:", SSE_cuadratico)
# CÚBICO
cat("\n\nMODELO CÚBICO\nVALORES AJUSTADOS: ", yest_cubico, "\nRESIDUALES", residuos_cubico, "\nSSE:", SSE_cubico)

# e) Para cada modelo: redecir la población que habrá en el año 2010. (que corresponde al codigo 7)
codigo_2010 <- 7
# LINEAL
cat("\n\nSegún el modelo lineal, la diferencia en 2010 en el modelo lineal será ", coefl[1] + coefl[2]*codigo_2010)
# CUADRÁTICO
cat("\nSegún el modelo cuadrático, la diferencia en 2010 en el modelo lineal será ", coefc[1] + coefc[2]*codigo_2010 + coefc[3]*codigo_2010^2)
# CÚBICO
cat("\nSegún el modelo cúbico, la diferencia en 2010 en el modelo lineal será ", coefcub[1] + coefcub[2]*codigo_2010 + coefcub[3]*codigo_2010^2 + coefcub[4]*codigo_2010^3)
