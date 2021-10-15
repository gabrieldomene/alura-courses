const { angular, ...frameworks } = cursos;
console.log("angular", angular);
console.log(frameworks);

const novosCursos = { angular, ...frameworks };
console.log(novosCursos);
