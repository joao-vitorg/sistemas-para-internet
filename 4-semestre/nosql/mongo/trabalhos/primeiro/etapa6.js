// ======================================================================
// 1. Indexando o campo name dos projetos
// ======================================================================
db.project.find({ name: /^Self-enabling/ }).explain("executionStats");
/*
    "executionStats": {
      "executionSuccess": true,
      "nReturned": 2,
      "executionTimeMillis": 0,
      "totalKeysExamined": 0,
      "totalDocsExamined": 100,
      ...
    }
*/

db.project.createIndex({ name: 1 });

db.project.find({ name: /^Self-enabling/ }).explain("executionStats");
/*
    "executionStats": {
      "executionSuccess": true,
      "nReturned": 2,
      "executionTimeMillis": 0,
      "totalKeysExamined": 3,
      "totalDocsExamined": 2,
      ...
    }
*/

// ======================================================================
// 2. Indexando os campos titulo e descricao das tarefas
// ======================================================================

db.project
	.find({ $or: [{ "tasks.title": /^adulatio/ }, { "tasks.description": /^adulatio/ }] })
	.explain("executionStats");
/*
    "executionStats": {
      "executionSuccess": true,
      "nReturned": 3,
      "executionTimeMillis": 1,
      "totalKeysExamined": 0,
      "totalDocsExamined": 100,
      ...
    }
*/

db.project.createIndex({ "tasks.title": 1 });
db.project.createIndex({ "tasks.description": 1 });
db.project.createIndex({ "tasks.title": 1, "tasks.description": 1 });

db.project
	.find({ $or: [{ "tasks.title": /^adulatio/ }, { "tasks.description": /^adulatio/ }] })
	.explain("executionStats");
/*
    "executionStats": {
      "executionSuccess": true,
      "nReturned": 3,
      "executionTimeMillis": 1,
      "totalKeysExamined": 5,
      "totalDocsExamined": 3,
      ...
    }
 */

// ======================================================================
// 3. Indexando o campo status das tarefas
// ======================================================================

db.project.find({ "tasks.status": "Concluida" }).explain("executionStats");
/*
    "executionStats": {
      "executionSuccess": true,
      "nReturned": 67,
      "executionTimeMillis": 0,
      "totalKeysExamined": 0,
      "totalDocsExamined": 100,
      ...
    }
*/

db.project.createIndex({ "tasks.status": 1 });

db.project.find({ "tasks.status": "Concluida" }).explain("executionStats");
/*
    "executionStats": {
      "executionSuccess": true,
      "nReturned": 67,
      "executionTimeMillis": 0,
      "totalKeysExamined": 67,
      "totalDocsExamined": 67,
      ...
    }
*/

// ======================================================================
// 4. Indexando o campo user das tarefas
// ======================================================================

db.project.find({ "tasks.user": ObjectId("65442e6c91637644bd6b946c") }).explain("executionStats");
/*
    "executionStats": {
      "executionSuccess": true,
      "nReturned": 46,
      "executionTimeMillis": 0,
      "totalKeysExamined": 0,
      "totalDocsExamined": 100,
      ...
    }
*/

db.project.createIndex({ "tasks.user": 1 });

db.project.find({ "tasks.user": ObjectId("65442e6c91637644bd6b946c") }).explain("executionStats");
/*
    "executionStats": {
      "executionSuccess": true,
      "nReturned": 46,
      "executionTimeMillis": 0,
      "totalKeysExamined": 46,
      "totalDocsExamined": 46,
      ...
    }
*/

// ======================================================================
// 5. Indexando o campo deadline_date das tarefas
// ======================================================================

db.project.find({ "tasks.deadline_date": { $lte: new Date("2024-01-01T00:00:00Z") } }).explain("executionStats");
/*
    "executionStats": {
      "executionSuccess": true,
      "nReturned": 94,
      "executionTimeMillis": 0,
      "totalKeysExamined": 0,
      "totalDocsExamined": 100,
      ...
    }
*/

db.project.createIndex({ "tasks.deadline_date": 1 });

db.project.find({ "tasks.deadline_date": { $lte: new Date("2024-01-01T00:00:00Z") } }).explain("executionStats");
/*
    "executionStats": {
      "executionSuccess": true,
      "nReturned": 94,
      "executionTimeMillis": 0,
      "totalKeysExamined": 107,
      "totalDocsExamined": 94,
      ...
    }
*/
