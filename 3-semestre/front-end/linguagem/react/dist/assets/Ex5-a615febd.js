import{r as n,j as s,a as r}from"./index-70105e74.js";function f(){const[t,e]=n.useState(""),[o,i]=n.useState(["Parágrafo 1 (interface)","Parágrafo 2 (interface)"]);return s("div",{children:[s("form",{children:[r("input",{type:"text",value:t,onChange:({target:a})=>e(a.value)}),r("button",{onClick:()=>{i([...o,t]),e("")},children:"Adicionar parágrafo"})]}),o.map((a,c)=>r("p",{children:a},c))]})}function u(){return r(f,{})}export{u as Component};
