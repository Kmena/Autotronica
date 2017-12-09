package eu.chargetime.ocpp.feature.profile;/*
    ChargeTime.eu - Java-OCA-OCPP
    
    MIT License

    Copyright (C) 2016 Thomas Volden <tv@chargetime.eu>

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
 */

import eu.chargetime.ocpp.feature.Feature;
import eu.chargetime.ocpp.feature.GetDiagnosticsFeature;
import eu.chargetime.ocpp.model.Confirmation;
import eu.chargetime.ocpp.model.Request;
import eu.chargetime.ocpp.model.firmware.GetDiagnosticsRequest;

import java.util.HashSet;
import java.util.UUID;

public class ClientFirmwareManagementProfile implements Profile {

    private HashSet<Feature> features;
    private ClientFirmwareManagementEventHandler eventHandler;

    public ClientFirmwareManagementProfile(ClientFirmwareManagementEventHandler eventHandler) {
        this.eventHandler = eventHandler;
        features = new HashSet<>();
        features.add(new GetDiagnosticsFeature(this));
    }

    @Override
    public Feature[] getFeatureList() {
        return features.toArray(new Feature[0]);
    }

    @Override
    public Confirmation handleRequest(UUID sessionIndex, Request request) {
        Confirmation result = null;

        if (request instanceof GetDiagnosticsRequest) {
            result = eventHandler.handleGetDiagnosticsRequest((GetDiagnosticsRequest) request);
        }

        return result;
    }
}
