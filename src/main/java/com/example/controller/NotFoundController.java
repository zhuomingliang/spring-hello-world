package com.example.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 自定义 404 NOT FOUND 页面，同时覆盖 Spring 原有的 /error 页面，
 * 参考：http://stackoverflow.com/questions/25356781/spring-boot-remove-whitelabel-error-page?answertab=votes#tab-top
 */
@Controller
public class NotFoundController implements ErrorController {

        @GetMapping     // 不存在的路径都会在这里被捕获
        @ResponseStatus(HttpStatus.NOT_FOUND)
        public String NotFoundAction() {
            return "not_found";
        }

		@Override
		public String getErrorPath() {
			// TODO Auto-generated method stub
			return null;
		}
}