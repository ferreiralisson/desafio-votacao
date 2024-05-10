import { HttpEvent, HttpHandler, HttpHandlerFn, HttpInterceptor, HttpInterceptorFn, HttpRequest } from "@angular/common/http";
import { Injectable, inject } from "@angular/core";
import { HelpersService } from "../services/helpers.service";
import { Observable, finalize } from "rxjs";

export const loaderInterceptor: HttpInterceptorFn = (req: HttpRequest<any>, next: HttpHandlerFn): Observable<HttpEvent<any>> => {
    const loaderService = inject(HelpersService); // Injeção explícita
    
    loaderService.showLoading();

    return next(req).pipe(
        finalize(() => loaderService.hideLoading())
    );
};
