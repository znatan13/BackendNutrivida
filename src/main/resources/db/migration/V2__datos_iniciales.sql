INSERT INTO trabajadores (nombre, imagen, especialidad, dias_horario, horario) VALUES
('Nut. Carolina Fuentes M.', '', 'Obesidad y síndrome metabólico', 'Lunes, Miércoles, Viernes', '09:00 – 17:00'),
('Nut. Rodrigo Sepúlveda A.', '', 'Nutrición deportiva y rendimiento', 'Martes, Jueves, Sábado', '09:00 – 14:00'),
('Nut. Daniela Morales C.', '', 'Alimentación vegetariana, vegana y trastornos alimentarios', 'Lunes a Viernes', '08:00 – 13:00'),
('Nut. Felipe Araya R.', '', 'Nutrición pediátrica y familiar', 'Martes a Viernes', '14:00 – 19:00');

INSERT INTO servicios (tipo, nombre, descripcion, duracion, modalidad, profesional, precio) VALUES
('consultas', 'Primera consulta nutricional', 'Evaluación inicial: Anammnesis, antropometria completa y diseño del primer plan alimenticio.', '50 minutos', 'Presencial', 'Nutricionista', 35000),
('consultas', 'Control nutricional(Seguimiento)', 'Seguimiento mensual: Medición de indicadores y ajuste del plan vigente.', '30 minutos', 'Presencial', 'Nutricionista', 25000),
('consultas', 'Control nutricional quincenal', 'Seguimiento Intenso cada 15 dias. Recomendado en los primeros 2 meses.', '30 minutos', 'Presencial', 'Nutricionista', 22000),
('consultas', 'Teleconsulta nutricional.', 'Consulta de seguimiento via videollamada. Requiere contar con consulta presencial previa.', '30 minutos', 'Online(Video)', 'Nutricionista', 20000),
('consultas', 'Consulta de urgencia / reagendada', 'Para pacientes que requieren atencion fuera de su control habitual', '30 minutos', 'Presencial', 'Nutricionista', 28000),
('evaluaciones', 'Antropometría completa', 'Peso, talla, IMC, circunferencia de cintura, cadera, brazo y % de grasa corporal y edad metabólica.', '20 minutos', 'Presencial', 'Nutricionista', 18000),
('evaluaciones', 'BioImedanclometría', 'Medición de composición corporal: masa grasa, masa muscular, agua corporal y edad metabólica.', '15 minutos', 'Presencial', 'Nutricionista', 12000),
('evaluaciones', 'Encuesta de hábitos alimentarios', 'Análisis del patrón alimentario actual. Identificación de déficit y excesos nutricionales.', '20 minutos', 'Presencial', 'Nutricionista', 10000),
('evaluaciones', 'Análisis de exámenes de laboratorio.', 'Interpretación de hemograma, perfil bloquímico y lipídico en contexto nutricional.', '20 minutos', 'Presencial', 'Nutricionista', 15000),
('grupales', 'Taller de alimentación saludable', 'Máx. 10 personas. Conceptos básicos de alimentación equilibrada y lectura de etiquetas.', '90 minutos', 'Presencial(Grupo)', 'Nutricionista', 15000),
('grupales', 'Taller de cocina nutritiva', 'Preparación de recetas saludables. Incluye degustación. Máx 8 personas.', '120 minutos', 'Presencial(Grupo)', 'Nutricionista', 20000),
('grupales', 'Taller nutrición para deportistas', 'Hidratación, nutricion pre y post entrenamiento, suplementación básica. Máx 12 personas.', '90 minutos', 'Presencial(Grupo)', 'Nutricionista', 18000),
('planes', 'Plan pérdida de peso', 'Incluye primera consulta +1 control quincenal + plan alimenticio personalizado + seguimiento por WhatsApp.', '1 mes', 'Presencial', 'Nutricionista', 65000),
('planes', 'Plan Pérdida de peso', 'Incluye primera consulta +5 controles + 3 planes mensuales + seguimiento continuo.', '3 meses', 'Presencial', 'Nutricionista', 170000),
('planes', 'Plan nutrición deportiva', 'Para deportistas y personas con actividad fisica frecuente. Cálculo de requerimientos energéticos y proteicos.', '1 mes', 'Presencial', 'Nutricionista', 70000),
('planes', 'Plan control diabetes / hipertensión', 'Plan adaptado para patologías metabólicas. Coordinación con médico tratante si aplica.', 'Dependiente', 'Presencial', 'Nutricionista', 75000),
('planes', 'Plan alimentación vegetariana / vegana', 'Diseñado para garantizar aporte adecuado de proteínas, hierro, vitamina B12 y calcio sin productos animales.', 'Dependiente', 'Presencial', 'Nutricionista', 68000),
('planes', 'Plan alimentación Infantil', 'Evaluación nutricional pediátrica y diseño de plan adaptado a la etapa de desarrollo del niño.', '2-12 años', 'Presencial', 'Nutricionista', 65000);
