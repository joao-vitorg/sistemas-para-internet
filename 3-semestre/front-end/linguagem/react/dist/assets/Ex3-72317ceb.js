import{r as o,j as e,a as t}from"./index-70105e74.js";function c({tamanhoMax:r}){const[a,n]=o.useState(0);return e("div",{children:[e("form",{children:[t("p",{children:"Mensagem:"}),t("textarea",{id:"texto",cols:"100",rows:"10",maxLength:r,onChange:({target:{value:s}})=>n(s.length)})]}),e("p",{children:["Restante: ",r-a," caracteres"]})]})}function x(){return t(c,{tamanhoMax:230})}export{x as Component};