import{j as n,a as r,L as l}from"./index-70105e74.js";const i=(c,t)=>n("div",{children:[r("h2",{style:{textTransform:"capitalize"},children:t.replaceAll("-"," ")}),r("ul",{children:[...Array(c).keys()].map(e=>r("li",{children:n(l,{to:`/${t}/ex${e+1}`,children:["Exercício ",e+1]})},e))})]});function o(){return n("div",{children:[i(4,"introducao"),i(5,"use-state")]})}export{o as Component};