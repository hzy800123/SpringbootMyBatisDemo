(this["webpackJsonpmy-app"]=this["webpackJsonpmy-app"]||[]).push([[0],{30:function(t,e,o){t.exports=o(64)},35:function(t,e,o){},53:function(t,e,o){},64:function(t,e,o){"use strict";o.r(e);var a=o(1),n=o.n(a),l=o(10),i=o.n(l),c=(o(35),o(26)),r=o(27),d=o(8),s=o(29),k=o(28),u=o(11),g=o.n(u),m=o(66),B=o(67),E=o(68),h=o(69),f=o(77),p=o(70),w=o(71),b=o(72),v=o(73),M=o(74),N=o(75),C=o(76),D="https://www.appvip2020.net",I=(o(53),function(t){Object(s.a)(o,t);var e=Object(k.a)(o);function o(t){var a;return Object(c.a)(this,o),(a=e.call(this,t)).state={books:[],newBookData:{title:"",rating:""},editBookData:{id:"",title:"",rating:""},newBookModal:!1,editBookModal:!1,openInvalidModal:!1},a.getAllBooks=function(){console.log("Start to contact to getallbook");var t="".concat(D,"/book/GetAllBook");g.a.get(t).then((function(t){console.log("Start to contact to getallbook"),a.setState({books:t.data})})).catch((function(t){console.log("Failed to contact to getallbook again."),console.log("err status: ",t.response.status),console.log("err code: ",t.response.code),console.log("Failed to contact to getallbook again. The err is ",t)}))},a.toogleNewBookModal=function(){a.setState({newBookModal:!a.state.newBookModal})},a.toogleEditBookModal=function(){a.setState({editBookModal:!a.state.editBookModal})},a.clickEditBook=function(t){a.setState({editBookData:{id:t.id,title:t.title,rating:t.rating},editBookModal:!a.state.editBookModal})},a.onInputNewTitleChange=function(t){var e=a.state.newBookData.rating,o=t.target.value;a.setState({newBookData:{title:o,rating:e}})},a.onInputNewRatingChange=function(t){var e=a.state.newBookData.title,o=t.target.value;a.setState({newBookData:{title:e,rating:o}})},a.onInputEditTitleChange=function(t){var e=a.state.editBookData,o=e.id,n=e.rating,l=t.target.value;a.setState({editBookData:{id:o,title:l,rating:n}})},a.onInputEditRatingChange=function(t){var e=a.state.editBookData,o=e.id,n=e.title,l=t.target.value;a.setState({editBookData:{id:o,title:n,rating:l}})},a.addNewBook=function(){var t="".concat(D,"/book/AddNewBook");g.a.post(t,a.state.newBookData).then((function(t){console.log(t.data),a.setState({books:t.data,newBookData:{title:"",rating:""},newBookModal:!1})})).catch((function(t){console.log("Failed to contact to getallbook. The err is ",t),a.setState({openInvalidModal:!0})}))},a.editBook=function(){var t="".concat(D,"/book/EditBook");g.a.post(t,a.state.editBookData).then((function(t){console.log(t.data),a.setState({books:t.data,editBookData:{id:"",title:"",rating:""},editBookModal:!1})})).catch((function(t){console.log("Failed to contact to getallbook. The err is ",t),a.setState({openInvalidModal:!0})}))},a.deleteBook=function(t){var e="".concat(D,"/book/DeleteBook");g.a.post(e,t).then((function(t){console.log(t.data),a.setState({books:t.data})})).catch((function(t){console.log("Failed to contact to getallbook. The err is ",t)}))},a.toggleInvalidModal=function(){a.setState({openInvalidModal:!1})},a.editBook=a.editBook.bind(Object(d.a)(a)),a.deleteBook=a.deleteBook.bind(Object(d.a)(a)),a.getAllBooks=a.getAllBooks.bind(Object(d.a)(a)),a.toogleNewBookModal=a.toogleNewBookModal.bind(Object(d.a)(a)),a.toogleEditBookModal=a.toogleEditBookModal.bind(Object(d.a)(a)),a.clickEditBook=a.clickEditBook.bind(Object(d.a)(a)),a.toggleInvalidModal=a.toggleInvalidModal.bind(Object(d.a)(a)),a}return Object(r.a)(o,[{key:"componentWillMount",value:function(){this.getAllBooks()}},{key:"render",value:function(){var t=this,e=this.state.books.map((function(e){return n.a.createElement("tr",{key:e.id},n.a.createElement("td",null,e.id),n.a.createElement("td",null,e.title),n.a.createElement("td",{className:"styled-ratingTd"},e.rating),n.a.createElement("td",{className:"styled-td"},n.a.createElement(m.a,{color:"success",size:"sm",className:"mr-1",onClick:function(){return t.clickEditBook(e)}},"Edit"),n.a.createElement(m.a,{color:"danger",size:"sm",onClick:function(){return t.deleteBook(e)}},"Del")))}));return n.a.createElement("div",{className:"App container"},n.a.createElement(B.a,{className:"themed-container",fluid:"md"},n.a.createElement(E.a,{className:"my-2"},n.a.createElement(h.a,{sm:"12",md:{size:6,offset:3}},n.a.createElement("h1",null,"Book App")),n.a.createElement(h.a,{sm:"12",md:{size:6,offset:3}},"version 2.0"))),n.a.createElement(B.a,{className:"themed-container",fluid:"md"},n.a.createElement(E.a,null,n.a.createElement(h.a,{sm:"12",md:{size:6,offset:8}},n.a.createElement(m.a,{color:"primary",onClick:function(){return t.toogleNewBookModal()}},"Add Book")))),n.a.createElement(f.a,{name:"New Book",isOpen:this.state.newBookModal,toggle:function(){return t.toogleNewBookModal()}},n.a.createElement(p.a,{toggle:function(){return t.toogleNewBookModal()}},"New Book Detail"),n.a.createElement(w.a,null,n.a.createElement(b.a,null,n.a.createElement(v.a,{for:"title"},"Title"),n.a.createElement(M.a,{id:"title",placeholder:"Input Book Title",value:this.state.newBookData.title,onChange:this.onInputNewTitleChange.bind(this)})),n.a.createElement(b.a,null,n.a.createElement(v.a,{for:"rating"},"Rating"),n.a.createElement(M.a,{id:"rating",placeholder:"Input Book Rating",value:this.state.newBookData.rating,onChange:this.onInputNewRatingChange.bind(this)}))),n.a.createElement(N.a,null,n.a.createElement(m.a,{color:"primary",onClick:function(){return t.addNewBook()}},"Add Book"),n.a.createElement(m.a,{color:"secondary",onClick:function(){return t.toogleNewBookModal()}},"Cancel"))),n.a.createElement(f.a,{name:"Edit Book",isOpen:this.state.editBookModal,toggle:function(){return t.toogleEditBookModal()}},n.a.createElement(p.a,{toggle:function(){return t.toogleEditBookModal()}},"Edit Book Detail"),n.a.createElement(w.a,null,n.a.createElement(b.a,null,n.a.createElement(v.a,{for:"title"},"Title"),n.a.createElement(M.a,{id:"title",placeholder:"Input Book Title",value:this.state.editBookData.title,onChange:this.onInputEditTitleChange.bind(this)})),n.a.createElement(b.a,null,n.a.createElement(v.a,{for:"rating"},"Rating"),n.a.createElement(M.a,{id:"rating",placeholder:"Input Book Rating",value:this.state.editBookData.rating,onChange:this.onInputEditRatingChange.bind(this)}))),n.a.createElement(N.a,null,n.a.createElement(m.a,{color:"primary",onClick:function(){return t.editBook()}},"Edit Book"),n.a.createElement(m.a,{color:"secondary",onClick:function(){return t.toogleEditBookModal()}},"Cancel"))),n.a.createElement(f.a,{isOpen:this.state.openInvalidModal},n.a.createElement(w.a,null,"Input Invalid Data."),n.a.createElement(N.a,null,n.a.createElement(m.a,{color:"danger",onClick:function(){return t.toggleInvalidModal()}},"Close"))),n.a.createElement(C.a,{striped:!0,className:"my-3"},n.a.createElement("thead",null,n.a.createElement("tr",null,n.a.createElement("th",{width:"5%"},"#"),n.a.createElement("th",{width:"40%"},"Title"),n.a.createElement("th",{width:"10%"},"Rating"),n.a.createElement("th",{width:"45%",className:"styled-th"},"Actions"))),n.a.createElement("tbody",null,e)))}}]),o}(a.Component));Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));o(63);i.a.render(n.a.createElement(I,null),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(t){t.unregister()})).catch((function(t){console.error(t.message)}))}},[[30,1,2]]]);
//# sourceMappingURL=main.c490bfbb.chunk.js.map