package com.sampledomain.bootstrap;

import com.sampledomain.send.UrlSendManager;
import org.springframework.stereotype.Service;

@Service
public class BootstrapService {
  private final UrlSendManager urlSendManager;

  public BootstrapService(UrlSendManager urlSendManager) {
    this.urlSendManager = urlSendManager;
  }

  public void run() {
    urlSendManager.send();
  }
}
