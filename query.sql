# Reporte de Campañas Publicitarias: Top 3 Empresas con Rentabilidad Positiva

## Estructura de Tablas

### Tabla `empresas`
| columna      | tipo        | descripción                 |
|--------------|-------------|-----------------------------|
| id           | INT         | Identificación de la empresa|
| nombre       | VARCHAR(255)| Nombre de la empresa        |
| tipo         | VARCHAR(255)| Tipo de la empresa          |
| descripción  | TEXT        | Descripción de la empresa   |

### Contenido `empresas`
| identificación | nombre                                                                          |
|----------------|---------------------------------------------------------------------------------|
| 1              | Lion Biotechnologies, Inc.                                                      |
| 2              | Boston Private Financial Holdings, Inc.                                         |
| 3              | Corporación Universal                                                           |
| 4              | Corporación Biofarmacéutica Arbutus                                             |
| 5              | Banco Real de Canadá                                                            |
| 6              | Penn West Petroleum Ltd                                                         |
| 7              | Almacenamiento público                                                          |
| 8              | Corporación de Recursos Halcon                                                  |
| 9              | Tecnologías TTM, Inc.                                                           |
| 10             | Atwood Oceanics, Inc.                                                           |
| 11             | ACADIA Pharmaceuticals Inc.                                                     |
| 12             | Empresas de medios de comunicación de Europa central Ltd.                       |
| 13             | Oxbridge Re Holdings Limited                                                    |
| 14             | Logística de refinación occidental, LP                                          |
| 15             | Vaalco Energy Inc                                                               |
| 16             | Xilinx, Inc.                                                                    |
| 17             | Liberty Global plc                                                              |
| 18             | Compañía Honda Motor, Ltd.                                                      |
| 19             | Great Plains Energy Inc                                                         |
| 20             | Assurant, Inc.                                                                  |
  
---

### Tabla `campañas`
| columna      | tipo        | descripción                  |
|--------------|-------------|------------------------------|
| empresa_id   | INT         | ID de la empresa asociada    |
| gastos       | DECIMAL(7,2)| Gastos de campaña            |
| ganancia     | DECIMAL(7,2)| Ingresos de campaña          |

### Contenido `campañas`
| ID de la empresa | gastos  | ganancia |
|------------------|---------|----------|
| 1                | 7390.24 | 8652.18  |
| 2                | 5774.65 | 7955.47  |
| 3                | 2154.71 | 5920.23  |
| 4                | 9366.49 | 3397.85  |
| 5                | 2765.18 | 9158.63  |
| 6                | 7908.41 | 5018.85  |
| 7                | 2251.44 | 6654.52  |
| 8                | 3383.14 | 9354.79  |
| 9                | 8287.96 | 9522.53  |
| 10               | 4356.62 | 4658.52  |
| 11               | 9272.86 | 9161.77  |
| 12               | 4996.18 | 5903.57  |
| 13               | 8354.75 | 2259.26  |
| 14               | 6402.90 | 8146.16  |
| 15               | 1692.05 | 686.71   |
| 16               | 5988.48 | 9089.41  |
| 17               | 6192.33 | 7580.19  |
| 18               | 3016.37 | 7761.25  |
| 19               | 9838.05 | 1293.09  |
| 20               | 4386.52 | 9513.73  |

---
# OUTPUT EXPECTED
### Top 3 Empresas con Mayor Ganancia

| Nombre de Empresa                   | Ganancia |
|-------------------------------------|----------|
| Banco Real de Canadá                | 6393.45  |
| Corporación de Recursos Halcon      | 5971.65  |
| Assurant, Inc.                      | 5127.21  |


---
  
## Consulta SQL

```sql
SELECT e.nombre AS company_name,
       (c.ganancia - c.gastos) AS profit
FROM empresas e
JOIN campañas c ON e.id = c.empresa_id
WHERE (c.ganancia - c.gastos) > 0
ORDER BY profit DESC
LIMIT 3;

