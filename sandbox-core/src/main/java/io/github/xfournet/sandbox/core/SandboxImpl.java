package io.github.xfournet.sandbox.core;

import io.github.xfournet.sandbox.Sandbox;

public class SandboxImpl implements Sandbox {
    @Override
    public String sayHello(String name) {
        return String.format("Hello %s!", name);
    }
}
