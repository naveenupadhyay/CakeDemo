(function(C){var A=C.scrollTo=function(F,E,D){C(window).scrollTo(F,E,D)
};
A.defaults={axis:"xy",duration:parseFloat(C.fn.jquery)>=1.3?0:1};
A.window=function(D){return C(window)._scrollable()
};
C.fn._scrollable=function(){return this.map(function(){var E=this,D=!E.nodeName||C.inArray(E.nodeName.toLowerCase(),["iframe","#document","html","body"])!=-1;
if(!D){return E
}var F=(E.contentWindow||E).document||E.ownerDocument||E;
return C.browser.safari||F.compatMode=="BackCompat"?F.body:F.documentElement
})
};
C.fn.scrollTo=function(F,E,D){if(typeof E=="object"){D=E;
E=0
}if(typeof D=="function"){D={onAfter:D}
}if(F=="max"){F=9000000000
}D=C.extend({},A.defaults,D);
E=E||D.speed||D.duration;
D.queue=D.queue&&D.axis.length>1;
if(D.queue){E/=2
}D.offset=B(D.offset);
D.over=B(D.over);
return this._scrollable().each(function(){var L=this,J=C(L),K=F,I,G={},M=J.is("html,body");
switch(typeof K){case"number":case"string":if(/^([+-]=)?\d+(\.\d+)?(px|%)?$/.test(K)){K=B(K);
break
}K=C(K,this);
case"object":if(K.is||K.style){I=(K=C(K)).offset()
}}C.each(D.axis.split(""),function(Q,R){var S=R=="x"?"Left":"Top",U=S.toLowerCase(),P="scroll"+S,O=L[P],N=A.max(L,R);
if(I){G[P]=I[U]+(M?0:O-J.offset()[U]);
if(D.margin){G[P]-=parseInt(K.css("margin"+S))||0;
G[P]-=parseInt(K.css("border"+S+"Width"))||0
}G[P]+=D.offset[U]||0;
if(D.over[U]){G[P]+=K[R=="x"?"width":"height"]()*D.over[U]
}}else{var T=K[U];
G[P]=T.slice&&T.slice(-1)=="%"?parseFloat(T)/100*N:T
}if(/^\d+$/.test(G[P])){G[P]=G[P]<=0?0:Math.min(G[P],N)
}if(!Q&&D.queue){if(O!=G[P]){H(D.onAfterFirst)
}delete G[P]
}});
H(D.onAfter);
function H(N){J.animate(G,E,D.easing,N&&function(){N.call(this,F,D)
})
}}).end()
};
A.max=function(J,I){var H=I=="x"?"Width":"Height",E="scroll"+H;
if(!C(J).is("html,body")){return J[E]-C(J)[H.toLowerCase()]()
}var G="client"+H,F=J.ownerDocument.documentElement,D=J.ownerDocument.body;
return Math.max(F[E],D[E])-Math.min(F[G],D[G])
};
function B(D){return typeof D=="object"?D:{top:D,left:D}
}})(jQuery);